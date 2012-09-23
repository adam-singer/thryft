from thryft.generator.named_construct import NamedConstruct


class Typedef(NamedConstruct):
    def __init__(self, type, **kwds): #@ReservedAssignment
        NamedConstruct.__init__(self, **kwds)
        self.__type = type

    @property
    def qname(self):
        return self.parent.name + '.' + self.name

    @property
    def type(self): #@ReservedAssignment
        return self.__type
