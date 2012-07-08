from thryft.target.construct import Construct


class Typedef(Construct):
    def __init__(self, name, parent, type): #@ReservedAssignment
        Construct.__init__(self, name=name, parent=parent)
        self.__type = type

    @property
    def type(self): #@ReservedAssignment
        return self.__type
