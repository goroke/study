class Node:
    def __init__(self, data=None):
        self.link = None
        self.data = data


class LinkedList:
    def __init__(self, subscriptable=None):
        self.__end = self.__head = None
        if subscriptable:
            for item in subscriptable: self.append(item)

    def append(self, data):
        if self.__head:
            self.__end.link = Node(data)
            self.__end = self.__end.link
        else:
            self.__head = self.__end = Node(data)

    def __getitem__(self, index):
        target = self.__head
        for i in range(index):
            if target.link:
                target = target.link
            else:
                raise IndexError

        return target.data


a = LinkedList(range(10))
print(list(a))
