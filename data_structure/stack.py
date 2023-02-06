class Stack:
    class UnderflowError(Exception):
        pass

    def __init__(self, size):
        self.__size = size
        self.__raw = [None] * size
        self.__top = -1

    def push(self, data):
        if self.__top == self.__size:
            raise OverflowError
        self.__top += 1
        self.__raw[self.__top] = data

    def pop(self):
        if self.top == -1:
            raise Stack.UnderflowError

        ret = self.__raw[self.__top]
        self.__raw[self.__top] = None
        self.__top -= 1
        return ret

    @property
    def top(self):
        return self.__top
