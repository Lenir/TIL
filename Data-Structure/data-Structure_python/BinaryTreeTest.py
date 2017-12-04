from BinaryTree import *
import unittest

class BinaryTreeTest(unittest.TestCase):
    def setUp(self):
        self.binaryTree = BinaryTree(8)
        self.binaryTree.addNode(3)
        self.binaryTree.addNode(10)
        self.binaryTree.addNode(6)
        self.binaryTree.addNode(1)
        self.binaryTree.addNode(4)
        self.binaryTree.addNode(14)
        self.binaryTree.addNode(7)
        self.binaryTree.addNode(13)

    def tearDown(self):
        del self.binaryTree

    def test_treeGen(self):
        binaryTree = BinaryTree(1000)
        self.assertEqual(1000, binaryTree.root.getValue())

    def test_addNode(self):
        binaryTree = BinaryTree(1000)
        binaryTree.addNode(-10)
        self.assertEqual(-10, binaryTree.root.lchild.value)

    def test_addSameNode(self):
        try:
            self.binaryTree.addNode(8)
        except AlreadyExistingValue:
            self.assert_

    def test_binarySearch(self):
        node10 = self.binaryTree.binarySearch(10)
        self.assertEqual(10, node10.value)

    def test_nodeNotFound(self):
        try:
            invalidNode = self.binaryTree.binarySearch(-777)
        except NodeNotFound:
            self.assert_

    def test_inOrderTraverse(self):
        answer = [1, 3, 4, 6, 7, 8, 10, 13, 14]
        inOrderTraverseList = []
        for node in self.binaryTree.inOrderTraverse():
            inOrderTraverseList.append(node.value)
        self.assertEqual(answer, inOrderTraverseList)

    def test_preOrderTraverse(self):
        answer = [8, 3, 1, 6, 4, 7, 10, 14, 13]
        preOrderTraverseList = []
        for node in self.binaryTree.preOrderTraverse():
            preOrderTraverseList.append(node.value)
        self.assertEqual(answer, preOrderTraverseList)

    def test_postOrderTraverse(self):
        answer = [1, 4, 7, 6, 3, 13, 14, 10, 8]
        postOrderTraverseList = []
        for node in self.binaryTree.postOrderTraverse():
            postOrderTraverseList.append(node.value)
        self.assertEqual(answer, postOrderTraverseList)


if __name__ == "__main__":
    unittest.main()