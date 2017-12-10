
class RedBlackTree:
    def __init__(self):
        self.root = None

    def insertValue(self, value):
        newNode = RBTNode(value)
        self.insertNode(newNode)

    def insertNode(self, node):
        try:
            terminalNode = self.getNearestNode(node.value)
            terminalNode.insertChildNode(node)
            node.fix_Insert()
            self.root = self.root.getRoot()
        except RootIsNoneException:
            self.root = RBTNode(node.value)
            self.root.fix_Insert()

    def getNode(self, value):
        result = self.getNearestNode(value)
        if result.value == value:
            return result
        else:
            raise NodeNotFoundException

    def getNearestNode(self, value):
        currentNode = self.root
        if currentNode == None:
            raise RootIsNoneException
        while True:
            try:
                if value > currentNode.value:
                    currentNode = currentNode.getRChild()
                elif value < currentNode.value:
                    currentNode = currentNode.getLChild()
                else:
                    return currentNode
            except NoneNodeRefernceException:
                return currentNode

    def print(self):
        self.root.printDescendantNodes()

class RBTNode:
    def __init__(self, value):
        self.value = value
        self.color = "RED"
        self.parent = None
        self.lChild = None
        self.rChild = None

    def insertChildNode(self, node):
        if node.value == self.value:
            raise AlreadyExistValueException
        else:
            node.parent = self
        if node.value > self.value :
            self.rChild = node
        else:
            self.lChild = node

    def fix_Insert(self):
        self.fix_InsertCase1()

    # case1 - node is root
    def fix_InsertCase1(self):
        if not self.hasParent():
            self.paintBlack()
        else:
            self.fix_InsertCase2()

    # case2 - parent node is BLACK
    def fix_InsertCase2(self):
        parent = self.getParent()
        if parent.isBlack():
            pass
        else:
            self.fix_InsertCase3()

    # case3 - parent and uncle are RED, reColor P, U, and Grandpa.
    def fix_InsertCase3(self):
        parent = self.getParent()
        try:
            uncle = self.getUncle()
            if parent.isRed() and uncle.isRed():
                grandpa = self.getGrandParent()
                parent.reColor()
                uncle.reColor()
                grandpa.reColor()
                grandpa.fix_InsertCase1()
            else:
                self.fix_InsertCase4()
        except NoneNodeRefernceException:
            self.fix_InsertCase4()

    # case4 - parent is RED, Uncle is BLACK, node tilted to Center ~ parent RR or RL
    def fix_InsertCase4(self):
        parent = self.getParent()
        grandpa = self.getGrandParent()
        try:
            if self is parent.getRChild() and parent is grandpa.getLChild():
                parent.rotateLeft()
                self = self.lChild()
            elif self is parent.getLChild() and parent is grandpa.getRChild():
                parent.rotateRight()
                self = self.rChild()
        except NoneNodeRefernceException:
            pass
        self.fix_InsertCase5()

    # case5 - tilted and parent and target node are RED, uncle is BLACK
    def fix_InsertCase5(self):
        grandpa = self.getGrandParent()
        parent = self.getParent()

        parent.paintBlack()
        grandpa.paintRed()
        try:
            if self is parent.getLChild():
                grandpa.rotateRight()
        except NoneNodeRefernceException:
            pass

        try:
            if self is parent.getRChild():
                grandpa.rotateLeft()
        except NoneNodeRefernceException:
            pass

    def rotateLeft(self):
        rChild = self.getRChild()
        try:
            rLChild = rChild.getLChild()
            rLChild.parent = self
        except NoneNodeRefernceException: # LChild Not Exist
            pass
        self.rChild = rChild.lChild
        rChild.lChild = self

        try:
            parent = self.getParent()
            rChild.parent = parent
            if parent.getLChild() is self:
                parent.lChild = rChild
            else:
                parent.rChild = rChild
        except NoneNodeRefernceException:
            rChild.parent = None
        self.parent = rChild

    def rotateRight(self):
        lChild = self.getLChild()
        try:
            lRChild = lChild.getRChild()
            lRChild.parent = self
        except NoneNodeRefernceException: #LRChild Not Exist
            pass

        self.lChild = lChild.rChild
        lChild.rChild = self

        try:
            parent = self.getParent()
            lChild.parent = parent
            if parent.getRChild() is self:
                parent.rChild = lChild
            else:
                parent.lChild = lChild
        except NoneNodeRefernceException:
            lChild.parent = None
        self.parent = lChild

    def printDescendantNodes(self):
        print("[" + str(self.value), end=" ")
        try:
            lChild = self.getLChild()
            print("Left : " + str(lChild.value), end=" ")
        except NoneNodeRefernceException:
            pass

        try:
            rChild = self.getRChild()
            print("Right : " + str(rChild.value), end=" ")
        except NoneNodeRefernceException:
            pass
        print("]")

        try:
            lChild = self.getLChild()
            lChild.printDescendantNodes()
        except NoneNodeRefernceException:
            pass

        try:
            rChild = self.getRChild()
            rChild.printDescendantNodes()
        except NoneNodeRefernceException:
            pass

    def getGrandParent(self):
        parent = self.getParent()
        return parent.getParent()

    def getUncle(self):
        parent = self.getParent()
        return parent.getSibling()

    def getSibling(self):
        parent = self.getParent()
        if parent.value > self.value: # self is left Child
            return parent.getRChild()
        else:
            return parent.getLChild()

    def getParent(self):
        if self.hasParent():
            return self.parent
        else:
            raise NoneNodeRefernceException

    def getRChild(self):
        return self.getChild("Right")

    def getLChild(self):
        return self.getChild("Left")

    def getChild(self, LeftOrRight):
        if LeftOrRight == "Left":
            if self.lChild == None:
                raise NoneNodeRefernceException
            else:
                return self.lChild
        elif LeftOrRight == "Right":
            if self.rChild == None:
                raise NoneNodeRefernceException
            else:
                return self.rChild
        else:
            raise InvalidArgumentException

    def hasParent(self):
        if self.parent == None:
            return False
        else:
            return True

    def hasChild(self):
        if self.lChild is not None or self.rChild is not None:
            return True
        else:
            return False

    def isBlack(self):
        if self.color == "BLACK":
            return True
        else:
            return False

    def isRed(self):
        if self.color == "RED":
            return True
        else:
            return False

    def paintBlack(self):
        self.color = "BLACK"

    def paintRed(self):
        self.color = "RED"

    def reColor(self):
        if self.isBlack():
            self.paintRed()
        else:
            self.paintBlack()

    # TODO - debug
    def getRoot(self):
        parent = self
        try:
            parent = parent.getParent()
            return parent.getRoot()
        except NoneNodeRefernceException:
            return parent


# Exceptions
class AlreadyExistValueException(Exception):
    pass

class NoneNodeRefernceException(Exception):
    pass

class InvalidArgumentException(Exception):
    pass

class NodeNotFoundException(Exception):
    pass

class RootIsNoneException(Exception):
    pass