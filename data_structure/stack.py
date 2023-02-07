class Stack:
    class UnderflowError(Exception):
        pass

    def __init__(self, size):
        self.__size = size
        self.__raw = [None] * size
        self.__top = -1

    def is_empty(self):
        return self.top == -1

    def is_full(self):
        return self.__top == self.__size - 1

    def push(self, data, raising_error_if_full=False):
        if self.is_full():
            if raising_error_if_full:
                raise OverflowError
            else:
                return

        self.__top += 1
        self.__raw[self.__top] = data

    def pop(self, raising_error_if_blank=False):
        if self.is_empty():
            if raising_error_if_blank:
                raise Stack.UnderflowError
            else:
                return

        ret = self.__raw[self.__top]
        self.__raw[self.__top] = None
        self.__top -= 1
        return ret

    @property
    def top(self):
        return self.__top
