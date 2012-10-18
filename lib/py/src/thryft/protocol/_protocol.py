class _Protocol(object):
    def readByte(self):
        return self.readI16()

    def readI16(self):
        return self.readI32()

    def writeByte(self, byte):
        self.writeI16(byte)

    def writeI16(self, i16):
        self.writeI32(i16)

    def writeMixed(self, object_):
        if isinstance(object_, float):
            self.writeDouble(object_)
        elif isinstance(object_, frozenset):
            self.writeSetBegin(len(object_))
            for item in object_:
                self.writeMixed(item)
            self.writeSetEnd()
        elif isinstance(object_, int):
            self.writeI32(object_)
        elif isinstance(object_, list):
            self.writeListBegin(len(object_))
            for item in object_:
                self.writeMixed(item)
            self.writeListEnd()
        elif isinstance(object_, long):
            self.writeI64(object_)
        elif isinstance(object_, basestring):
            self.writeString(object_)
        elif hasattr(object_, 'write'):
            object_.write(self)
        else:
            raise TypeError(type(object_))