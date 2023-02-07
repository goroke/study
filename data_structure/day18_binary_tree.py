from binarytree import BinaryNode


def post(node):
    if node.left: post(node.left)
    if node.right: post(node.right)
    print(node.data)


root = BinaryNode('ROOT')
A = BinaryNode('A')
B = BinaryNode('B')
root.left, root.right = A, B

lv2 = []
for lv1 in A, B:
    children = BinaryNode(lv1.data + '1'), BinaryNode(lv1.data + '2')
    lv1.left, lv1.right = children
    lv2.extend(children)

lv3 = []
for nd in lv2:
    children = BinaryNode(nd.data + '-1'), BinaryNode(nd.data + '-2')
    nd.left, nd.right = children
    lv3.extend(children)

post(root)
