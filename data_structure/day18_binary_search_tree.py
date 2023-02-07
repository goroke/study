from binarytree import BinaryNode


def add(root, value):
    """
    이진 탐색 트리에 값을 넣습니다.
    :param root: 이진 탐색 트리의 루트
    :param value: 넣을 값
    :return: 성공 여부
    """
    current = root
    while True:
        if value > current.data:
            if current.right:
                current = current.right
                continue
            else:
                current.right = BinaryNode(value)
                return True

        if value < current.data:
            if current.left:
                current = current.left
                continue
            else:
                current.left = BinaryNode(value)
                return True

        return False


def inorder(node):
    if node.left: inorder(node.left)
    print(node.data)
    if node.right: inorder(node.right)


import random

root = BinaryNode(50)
for i in range(1, 101):
    add(root, random.randint(1, 100))

inorder(root)
