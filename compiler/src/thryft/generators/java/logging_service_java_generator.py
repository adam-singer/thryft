from thryft.generators.java import java_generator
from thryft.generators.java.java_document import JavaDocument
from thryft.generators.java.java_function import JavaFunction
from thryft.generators.java.java_service import JavaService
from yutil import indent, camelize, lpad
import os.path


class LoggingServiceJavaGenerator(java_generator.JavaGenerator):
    class LoggingServiceJavaDocument(JavaDocument):
        def _save(self, out_file_path):
            out_dir_path, out_file_name = os.path.split(out_file_path)
            out_file_base_name, out_file_ext = os.path.splitext(out_file_name)
            out_file_path = os.path.join(out_dir_path, 'Logging' + camelize(out_file_base_name) + out_file_ext)
            JavaDocument._save(self, out_file_path)

    Document = LoggingServiceJavaDocument

    class Function(JavaFunction):
        def java_message_types(self):
            message_types = []
            if len(self.parameters) > 0:
                message_types.append(self.java_request_type(java_suppress_warnings=('serial',)))
            if self.return_type is not None:
                message_types.append(self.java_response_type())
            return message_types

        def __repr__(self):
            java_name = self.java_name()
            name = self.name

            local_declarations = []
            if len(self.parameters) > 0 or self.return_type is not None:
                local_declarations.append('java.io.StringWriter __logMessageStringWriter;')
                local_declarations.append('org.thryft.core.protocol.LogMessageProtocol __logMessageProtocol;')
            local_declarations.append('final StringBuilder __logMessageStringBuilder = new StringBuilder();')
            local_declarations = "\n".join(indent(' ' * 4, local_declarations))

            parameters = \
                ', '.join([parameter.java_parameter(final=True)
                           for parameter in self.parameters])
            parameter_names = ', '.join([parameter.java_name()
                                         for parameter in self.parameters])

            if len(self.parameters) > 0:
                parameters_toString = indent(' ' * 4, """
try {
    __logMessageStringWriter = new java.io.StringWriter();
    __logMessageProtocol = new org.thryft.core.protocol.LogMessageProtocol(__logMessageStringWriter);               
    new %(java_name)sRequest(%(parameter_names)s).write(__logMessageProtocol);
    __logMessageProtocol.flush();
    __logMessageStringBuilder.append(__logMessageStringWriter.toString());
} catch (final java.io.IOException e) {
    __logMessageStringBuilder.append("(serialization error)");
} catch (final org.apache.thrift.TException e) {
    __logMessageStringBuilder.append("(serialization error)");
}
""" % locals())
            else:
                parameters_toString = ''

            return_type_name = \
                self.return_type is not None and \
                    self.return_type.java_declaration_name() or \
                    'void'

            service_call = """\
service.%(java_name)s(%(parameter_names)s);
""" % locals()
            if self.return_type is not None:
                service_call = self.return_type.java_qname(boxed=False) + ' __returnValue = ' + service_call
                service_call += """
__logMessageStringBuilder.append(" -> ");
try {
    __logMessageStringWriter = new java.io.StringWriter();
    __logMessageProtocol = new org.thryft.core.protocol.LogMessageProtocol(__logMessageStringWriter);
    new %(java_name)sResponse(__returnValue).write(__logMessageProtocol, org.apache.thrift.protocol.TType.VOID);
    __logMessageProtocol.flush();
    __logMessageStringBuilder.append(__logMessageStringWriter.toString());
} catch (final java.io.IOException e) {
    __logMessageStringBuilder.append("(serialization error)");
} catch (final org.apache.thrift.TException e) {
    __logMessageStringBuilder.append("(serialization error)");
}
logger.info(__logMessageStringBuilder.toString());

return __returnValue;
""" % locals()
            else:
                service_call += """
logger.info(__logMessageStringBuilder.toString());                
"""
            service_call = indent(' ' * 4, service_call)
            if len(self.throws) > 0:
                catches = ' '.join(["""\
catch (final %s e) {
        __logMessageStringBuilder.append(" -> ");
        __logMessageStringBuilder.append(e.getMessage());
        logger.error(__logMessageStringBuilder.toString());
        throw e;
    }""" % throw.type.java_declaration_name() for throw in self.throws])
                service_call = """\
    try {
%s
    } %s""" % (indent(' ' * 4, service_call), catches)

            throws = \
                lpad(
                    ' throws ',
                    ', '.join([field.type.java_declaration_name()
                               for field in self.throws])
                )
            return """\
public %(return_type_name)s %(java_name)s(%(parameters)s)%(throws)s {
%(local_declarations)s

    final org.apache.shiro.subject.Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
    if (currentUser.getPrincipal() instanceof String) {
        __logMessageStringBuilder.append((String)currentUser.getPrincipal());
        __logMessageStringBuilder.append(": " );
    }
    
    __logMessageStringBuilder.append("%(name)s(");%(parameters_toString)s
    __logMessageStringBuilder.append(")");

%(service_call)s
}""" % locals()

    class Service(JavaService):
        def _java_name(self, boxed=False):
            return 'Logging' + JavaService.java_name(self)

        def _java_constructor(self):
            name = self._java_name()
            service_qname = JavaService.java_qname(self)
            return """\
public %(name)s(final %(service_qname)s service) {
    this.service = service;
}""" % locals()

        def _java_member_declarations(self):
            name = self._java_name()
            service_qname = JavaService.java_qname(self)
            return [
                "private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(%(name)s.class);" % locals(),
                "private final %(service_qname)s service;" % locals()
            ]

        def _java_methods(self):
            return [repr(function) for function in self.functions]

        def __repr__(self):
            name = self._java_name()

            sections = []

            message_types = []
            for function in self.functions:
                message_types.extend(function.java_message_types())
            sections.append(
                "\n\n".join([repr(message_type)
                           for message_type in message_types])
            )

            sections.append("\n\n".join([self._java_constructor()] + self._java_methods()))
            sections.append("\n".join(self._java_member_declarations()))
            sections = "\n\n".join(indent(' ' * 4, sections))

            service_qname = self.java_qname()

            return """\
@com.google.inject.Singleton           
public class %(name)s implements %(service_qname)s {
%(sections)s
}""" % locals()
