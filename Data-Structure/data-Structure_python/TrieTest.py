from Trie import *
import unittest


class TrieTest(unittest.TestCase):
    def setUp(self):
        self.trie = Trie()
        self.trie.insertWord("Spam!")

    def tearDown(self):
        del self.trie

    def test_trieGen(self):
        self.assertTrue(self.trie is not None)

    def test_charInput(self):
        self.assertEqual(self.trie.root.getChildNode("S").char, "S")

    def test_wordInput(self):
        self.assertTrue(self.trie.hasWord("Spam!"))

    def test_getWords(self):
        self.trie.insertWord("Spam?")
        words = self.trie.getWords()
        self.assertIn("Spam?", words)
        self.assertIn("Spam!", words)

    def test_ChildNotFoundExceptionRaises(self):
        with self.assertRaises(ChildNodeNotFound):
            self.trie.root.getChildNode("*")

    def test_getNodeNum(self):
        self.trie.insertWord("Spam?!")
        self.trie.insertWord("Spam!!")
        nodenum = self.trie.getNodeNum()
        # root, S, p, a, m, ! / ?, ! / !
        self.assertEqual(9, nodenum)
