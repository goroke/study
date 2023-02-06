import random

class Node:
    def __init__(self, data=None):
        self.link = None
        self.data = data

    def __repr__(self):
        return "N"+str(self.data) if self.data else "Empty"


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

    def insert(self, search, data):
        """
        데이터를 찾고, 찾은 데이터 뒤에 새로운 값을 삽입합니다.
        (없는 경우, 마지막에 삽입됩니다.)
        :param search: 찾을 값
        :param data: 삽입할 값
        :return: 없음
        """
        item = self.__head
        while item.link:
            if item.data == search:
                new_node = Node(data)
                new_node.link = item.link
                item.link = new_node

                if item == self.__end: self.__end = new_node
                break
            else:
                item = item.link

    def insert_arrange_rev(self, data, idx_if_list=None):
        current = self.__head
        node = Node(data)

        if self.__head is None:
            self.__head = self.__end = node
            return

        if (not idx_if_list and current.data < data) or \
                idx_if_list and current.data[idx_if_list] < data[idx_if_list]:
            node.link = self.__head
            self.__head = node
            return

        while current.link:
            pre = current
            current = current.link
            if (not idx_if_list and current.data < data) or \
                    idx_if_list and current.data[idx_if_list] < data[idx_if_list]:
                pre.link = node
                node.link = current
                return

        current.link = node
        self.__end = node

    def delete(self, data):
        item = self.__head
        if item.data == data:
            if item.link:
                self.__head = item.link
            else:
                self.__head = None
            print("첫 번째 노드 삭제 완료")
            return

        while item.link:
            if item.link.data == data:
                item.link = item.link.link
                print("중간 노드 삭제 완료")
                break

            item = item.link

        else:
            print("못 찾음")

    def find(self, data):
        item = self.__head
        while item.link:
            if item.data == data:
                return item
            else:
                item = item.link

        return Node()

    def __getitem__(self, index):
        target = self.__head
        for i in range(index):
            if target.link:
                target = target.link
            else:
                raise IndexError

        return target.data


if __name__ == "__main__":
    c = LinkedList()

    dataArray = [['지민', 180], ['정국', 177], ['뷔', 183], ['슈가', 175], ['진', 179]]

    for d in dataArray: c.insert_arrange_rev(d, 1)
    print(list(c))

    lotto = LinkedList()
    for i in range(6):
        lotto.insert_arrange_rev(random.randint(1, 45))

    print(list(lotto))
