from thryft.target.compound_types.enum_type import EnumType
from thryft.targets.java.java_compound_type import JavaCompoundType
from yutil import indent


class JavaEnumType(EnumType, JavaCompoundType):
    def java_hash_code(self, value):
        return "%(value)s.ordinal()" % locals()

    def java_write_protocol(self, value, depth=0):
        return "oprot.writeI32(%(value)s.ordinal());" % locals()

    def __repr__(self):
        name = self.java_name()
        if len(self.fields) == 0:
            return """\
public enum %(name)s {
}"""
        for enumerator in self.fields:
            if enumerator.value is not None:
                enumerators = []
                for enumerator in self.fields:
                    enumerators.append(
                        "%s(%u)" % (enumerator.name, enumerator.value)
                    )
                enumerators = ",\n".join(indent(' ' * 4, enumerators))
                return """\
public enum %(name)s {
%(enumerators)s;

    private %(name)s(int value) {
        this.value = value;
    }

    public final int value() {
        return value;
    }

    private final int value;
}""" % locals()

        enumerators = \
            ",\n".join(indent(' ' * 4,
                [enumerator.name for enumerator in self.fields]
            ))
        return """public enum %(name)s {
%(enumerators)s
}""" % locals()
