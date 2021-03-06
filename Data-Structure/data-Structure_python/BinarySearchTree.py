class BinarySearchTree:
    root = None

    def __init__(self):
        self.root = None

    def addValue(self, value):
        child = Node(value)
        self.addNode(child)

    def addNode(self, node):
        if self.root is None:
            self.root = node
        else:
            self.root.addChild(node)

    def binarySearch(self, value):
        return self.root.binarySearch(value)

    def inOrderTraverse(self):
        return self.root.inOrderTraverse(self.root)

    def preOrderTraverse(self):
        return self.root.preOrderTraverse(self.root)

    def postOrderTraverse(self):
        return self.root.postOrderTraverse(self.root)


class Node:

    def getValue(self):
        return self.value

    def addChild(self, child):
        terminalNode = self.getTerminalNode(child)
        if child.getValue() > terminalNode.getValue() :
            terminalNode.setRchild(child)
        elif child.getValue() < terminalNode.getValue():
            terminalNode.setLchild(child)
        else:
            raise AlreadyExistingValue

    def setLchild(self, child):
        self.lchild = child

    def setRchild(self, child):
        self.rchild = child

    def getLchild(self):
        return self.lchild

    def getRchild(self):
        return self.rchild

    def binarySearch(self, value):
        if value > self.value:
            if self.rchild is None:
                raise NodeNotFound
            else:
                return self.rchild.binarySearch(value)
        elif value < self.value:
            if self.lchild is None:
                raise NodeNotFound
            else:
                return self.lchild.binarySearch(value)
        else:
            return self


    def getTerminalNode(self, child):
        if child.getValue() is self.getValue():
            return self
        elif child.getValue() > self.getValue() :
            if self.rchild is None:
                return self
            else:
                return self.rchild.getTerminalNode(child)
        elif child.getValue() < self.getValue():
            if self.lchild is None:
                return self
            else:
                return self.lchild.getTerminalNode(child)

    def inOrderTraverse(self, node):
        # in order travel. left, self, right child visit.
        visited = []
        if node.lchild is not None:
            visited += (node.inOrderTraverse(node.lchild))
        if node is not None:
            visited += [node]
        if node.rchild is not None:
            visited += (node.inOrderTraverse(node.rchild))
        return visited

    def preOrderTraverse(self, node):
        # pre order travel. self, left, right child visit.
        visited = []
        if node is not None:
            visited += [node]
        if node.lchild is not None:
            visited += (node.preOrderTraverse(node.lchild))
        if node.rchild is not None:
            visited += (node.preOrderTraverse(node.rchild))
        return visited

    def postOrderTraverse(self, node):
        # pre order travel. left, right child, self visit.
        visited = []
        if node.lchild is not None:
            visited += (node.postOrderTraverse(node.lchild))
        if node.rchild is not None:
            visited += (node.postOrderTraverse(node.rchild))
        if node is not None:
            visited += [node]
        return visited

    def __init__(self, value):
        # init with value
        self.value = value
        self.lchild = None
        self.rchild = None

    def __str__(self):
        return "< Node : " + str(self.value) +" >"


class AlreadyExistingValue(Exception):
    pass

class NodeNotFound(Exception):
    pass


def main():
    binaryTree = BinarySearchTree(77)
    binaryTree.addNode(50)
    binaryTree.addNode(60)
    binaryTree.addNode(20)
    binaryTree.addNode(100)
    try:
        print("Searching for 60 : " + str(binaryTree.binarySearch(60)))
        print("Searching for 60 : " + str(binaryTree.binarySearch(90)))
    except NodeNotFound:
        print("NodeNotFound")

    # inOrderTraversalList = binaryTree.inOrderTraverse()
    # for element in inOrderTraversalList:
    #     print(element.getValue(), end=" ")

if __name__ == '__main__':
    main()
