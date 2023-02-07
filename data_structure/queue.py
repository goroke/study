class Queue:
    def __init__(self, size):
        self.__size = size
        self.__raw = [None] * size
        self.__front = self.__rear = -1

    def enqueue(self, data):
        if self.is_full():
            return

        self.__rear += 1
        self.__raw[self.__rear] = data

    def dequeue(self):
        if self.is_empty():
            return

        self.__front += 1
        ret = self.__raw[self.__front]
        return ret

    def peek(self):
        if self.is_empty():
            return

        return self.__raw[self.__front + 1]

    def is_empty(self):
        return self.__front == self.__rear

    def is_full(self):
        if self.__rear - self.__front == self.__size:
            return True

        if self.__rear == self.__size - 1:
            for i in range(self.__front + 1, self.__size):
                self.__raw[i] = self.__raw[i-1]
                self.__raw[i] = None

            self.__rear -= 1
            self.__front -= 1

        return False
