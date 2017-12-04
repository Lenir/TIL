class binaryTree:
    root = None

    def __init__(self, value):
        self.root = node(value)


class node:
    value = None
    lchild = None
    rchild = None

    def setValue(self, value):
        self.value = value

    def getValue(self):
        return self.value

    def setLchild(self, child):
        self.lchild = child

    def setRchild(self, child):
        self.rchild = child

    def getLchild(self):
        return self.lchild

    def getRchild(self):
        return self.rchild

    def inOrderTravel(self, node):
        # in order travel. left, self, right child visit.
        visited = []
        if node.lchild is not None:
            visited += (node.inOrderTravel(node.lchild))
        if node is not None:
            visited += [node]
        if node.rchild is not None:
            visited += (node.inOrderTravel(node.rchild))
        return visited

    def preOrderTravel(self, node):
        # pre order travel. self, left, right child visit.
        visited = []
        if node is not None:
            visited += [node]
        if node.lchild is not None:
            visited += (node.preOrderTravel(node.lchild))
        if node.rchild is not None:
            visited += (node.preOrderTravel(node.rchild))
        return visited

    def postOrderTravel(self, node):
        # pre order travel. left, right child, self visit.
        visited = []
        if node.lchild is not None:
            visited += (node.postOrderTravel(node.lchild))
        if node.rchild is not None:
            visited += (node.postOrderTravel(node.rchild))
        if node is not None:
            visited += [node]
        return visited

    def __init__(self, value):
        # init with value
        self.setValue(value)


def main():
    btree = binaryTree(3)
    node1 = node(4)
    node2 = node(5)
    node1_1 = node(7)
    node1_2 = node(8)
    btree.root.setLchild(node1)
    btree.root.setRchild(node2)
    node1.setLchild(node1_1)
    node1.setRchild(node1_2)

    travelList = btree.root.postOrderTravel(btree.root)
    for element in travelList:
        print(element.getValue())

if __name__ == '__main__':
    main()
