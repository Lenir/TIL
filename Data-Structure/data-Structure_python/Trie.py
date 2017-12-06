class Trie:
    def __init__(self):
        self.root = TrieNode('')

    def insertWord(self, word:str):
        self.root.addWord(word)

    def hasWord(self, word:str):
        nextNode = self.root
        for char in word:
            try:
                nextNode = nextNode.getChildNode(char)
            except ChildNodeNotFound:
                return False
        return True

    def getWords(self):
        return self.root.getWordsFromHere()

    def getNodeNum(self):
        return self.root.getNodeNumFromHere()


class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = []

    def addWord(self, word:str):
        isLast = False
        nextNode = None
        if len(word) == 1:
            isLast = True
        wordFirstChar = word[0]
        if self.hasChildChar(wordFirstChar):
            nextNode = self.getChildNode(wordFirstChar)
        else:
            nextNode = TrieNode(wordFirstChar)
            self.addChildNode(nextNode)
        if not isLast:
            leftChars = word[1:]
            nextNode.addWord(leftChars)

    def getWordsFromHere(self):
        result = []
        curPostFixes = []
        if self.hasChildren():
            for child in self.children:
                curPostFixes.extend(child.getWordsFromHere())
            for postfix in curPostFixes:
                curChar = self.char
                result.append(curChar + postfix)
            return result
        else:
            return list(self.char)

    def getNodeNumFromHere(self):
        sum = 0
        if self.hasChildren():
            for child in self.children:
                sum += child.getNodeNumFromHere()
        else:
            return 1
        return sum + 1


    def hasChildren(self):
        if len(self.children) > 0:
            return True
        return False

    def getChildNode(self, char):
        for child in self.children:
            if child.char == char:
                return child
        raise ChildNodeNotFound

    def addChildNode(self, child):
        self.children.append(child)

    def hasChildChar(self, char):
        for child in self.children:
            if child.char == char:
                return True
        return False


class ChildNodeNotFound(Exception):
    pass


if __name__ == "__main__":
    trie = Trie()
    trie.insertWord("SPAM")
    trie.insertWord("SPAM!")
    trie.insertWord("SPAM?")
    trie.insertWord("SPAM*")
    trie.insertWord("SPAM.")
    trie.insertWord("SPAM;")

    print(trie.getWords())
    print(trie.getNodeNum())
