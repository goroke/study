from node import Node
import random


def count_plus_minus():
    global head
    p, m, z = 0, 0, 0
    current = head

    while True:
        if current.data > 0:
            p += 1
        elif current.data < 0:
            m += 1
        else:
            z += 1

        if current.link == head:
            break

        current = current.link

    return p, m, z


#def make_minus_number(odd, even):
#    global head
#
#    current = head
#    while current.link != head:
#        if current.data % 2 == remainder:


def make_minus_number():
    while current.link != head:
        current.data *= -1
        current = current.link


if __name__ == "__main__":
    global head
    head = Node()
    current = head

    for i in range(7):
        current.data = random.randint(-100, 100)
        print(current.data, end=" ")
        if i < 6:
            current.link = Node()
            current = current.link
        else:
            current.link = head
    print()

    print(count_plus_minus())
