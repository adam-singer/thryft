from thryft.target.compound_type import CompoundType
from yutil import pad, indent


class ThriftEnum(CompoundType):
    def __repr__(self):
        return "enum %s {%s}" % (
            self.name,
            pad("\n", indent(' ' * 4, ",\n".join(
                [enumerator.value is not None and \
                    "%s = %s" % (enumerator.name, enumerator.value) or \
                 enumerator.name
                 for enumerator in self.fields]
            )), "\n")
        )
