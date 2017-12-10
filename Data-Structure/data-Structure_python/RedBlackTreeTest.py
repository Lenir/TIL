from RedBlackTree import *
import unittest

class RedBlackTreeTest(unittest.TestCase):
    def setUp(self):
        self.rbt = RedBlackTree()
        self.rbt.insertValue(10)

    def tearDown(self):
        del self.rbt

    def test_RBTreeGen(self):
        self.assertTrue(self.rbt.root is not None)

    def test_RBTreeInsertNode(self):
        self.assertEqual(10, self.rbt.root.value)

    def test_RBTChildNodeInsert(self):
        self.rbt.insertValue(20)
        self.assertEqual(20, self.rbt.getNode(20).value)

    def test_RootIsBlack(self):
        self.assertTrue(self.rbt.root.isBlack())

    def test_printingRBT(self):
        self.rbt.insertValue(20)
        self.rbt.insertValue(30)
        self.rbt.insertValue(40)
        self.rbt.print()
        self.assertTrue(True)

    def test_balancing(self):
        self.rbt.insertValue(20)
        self.rbt.insertValue(30)
        self.rbt.insertValue(40)
        self.rbt.insertValue(50)
        self.rbt.print()
        self.assertEqual(20, self.rbt.root.value)