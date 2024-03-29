from thryft.protocol._abstract_output_protocol import _AbstractOutputProtocol


class _StackedOutputProtocol(_AbstractOutputProtocol):
    def __init__(self):
        _AbstractOutputProtocol.__init__(self)
        self._output_protocol_stack = []

    def write_bool(self, value):
        self._output_protocol_stack[-1].write_bool(value)

    def write_byte(self, value):
        self._output_protocol_stack[-1].write_byte(value)

    def write_date_time(self, value):
        self._output_protocol_stack[-1].write_date_time(value)

    def write_decimal(self, value):
        self._output_protocol_stack[-1].write_decimal(value)

    def write_email_address(self, value):
        self._output_protocol_stack[-1].write_email_address(value)

    def write_field_begin(self, name, *args, **kwds):
        self._output_protocol_stack[-1].write_field_begin(name, *args, **kwds)

    def write_field_end(self):
        self._output_protocol_stack[-1].write_field_end()

    def write_field_stop(self):
        self._output_protocol_stack[-1].write_field_stop()

    def write_i16(self, value):
        self._output_protocol_stack[-1].write_i16(value)

    def write_i32(self, value):
        self._output_protocol_stack[-1].write_i32(value)

    def write_i64(self, value):
        self._output_protocol_stack[-1].write_i16(value)

    def write_list_begin(self, *args, **kwds):
        self._output_protocol_stack[-1].write_list_begin(*args, **kwds)

    def write_list_end(self):
        self._output_protocol_stack.pop(-1)
        self._output_protocol_stack[-1].write_list_end()

    def write_map_begin(self, *args, **kwds):
        self._output_protocol_stack[-1].write_map_begin(*args, **kwds)

    def write_map_end(self):
        self._output_protocol_stack.pop(-1)
        self._output_protocol_stack[-1].write_list_end()

    # Do not include write_mixed

    def write_null(self):
        self._output_protocol_stack[-1].write_null()

    def write_set_begin(self, *args, **kwds):
        self._output_protocol_stack[-1].write_set_begin(*args, **kwds)

    def write_set_end(self):
        self._output_protocol_stack.pop(-1)
        self._output_protocol_stack[-1].write_set_end()

    def write_string(self, value):
        self._output_protocol_stack[-1].write_string(value)

    def write_struct_begin(self, *args, **kwds):
        self._output_protocol_stack[-1].write_struct_begin(*args, **kwds)

    def write_struct_end(self):
        self._output_protocol_stack.pop(-1)
        self._output_protocol_stack[-1].write_struct_end()

    def write_uri(self, value):
        self._output_protocol_stack[-1].write_uri(value)

    def write_url(self, value):
        self._output_protocol_stack[-1].write_url(value)
