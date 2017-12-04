class heap:
    '''
    number of node depth goes with 2^(depth) index. e.g) 1, 2, 4, 8...
    so get some depth's start, 2^(depth)-1, depth goes 0, 1...
    e.g) 1st = 0, 2nd = 2 - 1 = 1 , 3rd = 4 - 1 =  3, 4th = 8 - 1 = 7..
    '''
    isMinheap = True
    nodes = []

    def setValue(self, index, value):
        if len(self.nodes) - 1 < index:
            # print("index out of bound")
            pass
        else:
            self.nodes[index] = value

    def getValue(self, index):
        # returns node value via index
        if len(self.nodes) - 1 < index:
            # print("index out of bound")
            return None
        else:
            return self.nodes[index]

    def getParent(self, index):
        # get parent's index.
        return (index - 1) // 2

    def getLChild(self, index):
        # get left child's index.
        return ((index * 2) + 1)

    def getRChild(self, index):
        # get right child's index.
        return ((index * 2) + 2)

    def swapNode(node1, node2):
        node1, node2 = node1, node2

    def popRoot(self):
        # return root and fix heap
        print("pop from heap : ", self.nodes)
        if self.nodes is not None:
            root = self.getValue(0)
            # get last element in root and fix heap
            self.setValue(0, self.nodes.pop())
            index = 0
            if self.isMinheap:
                while index <= len(self.nodes) - 1:
                    curnode = self.getValue(index)
                    rindex = self.getRChild(index)
                    lindex = self.getLChild(index)
                    rchild = self.getValue(self.getRChild(index))
                    lchild = self.getValue(self.getLChild(index))
                    if (rchild is not None) and (lchild is not None):
                        # node has 2 child.
                        if (rchild > curnode) and (lchild > curnode):
                            # if current node is smaller than children
                            return root
                        else:
                            # smaller child exist.
                            if rchild > lchild:
                                # left child is smaller. swap
                                self.nodes[lindex], self.nodes[index] = self.nodes[index], self.nodes[lindex]
                                index = lindex
                            else:
                                # right child is smaller. swap
                                self.nodes[rindex], self.nodes[index] = self.nodes[index], self.nodes[rindex]
                                index = rindex
                    elif (rchild is None) and (lchild is None):
                        # leaf node.
                        return root
                    else:
                        # has one child. (left child)
                        if (lchild < curnode):
                            self.nodes[lindex], self.nodes[index] = self.nodes[index], self.nodes[lindex]
                            index = lindex
                        else:
                            return root
            return root
        else:
            print("nodes empty!")
            return None

    def insertNode(self, val):
        # push value, and fix heap from bottom
        index = len(self.nodes)
        if val not in self.nodes:
            self.nodes.append(val)
            # fixing heap
            if self.isMinheap:
                # minheap
                while index is not 0:
                    parIdx = self.getParent(index)
                    if self.getValue(parIdx) < self.getValue(index):
                        # if minheap, parent is smaller than input.
                        break
                    else:
                        # swap and fix til reaches root
                        self.nodes[index], self.nodes[parIdx] = self.nodes[parIdx], self.nodes[index]
                        index = parIdx
            else:
                # maxheap
                while index is not 0:
                    parIdx = self.getParent(index)
                    if self.getValue(parIdx) > self.getValue(index):
                        # if minheap, parent is greater than input.
                        break
                    else:
                        # swap and fix til reaches root
                        self.nodes[index], self.nodes[parIdx] = self.nodes[parIdx], self.nodes[index]
                        index = parIdx

        else:
            print("existing value :", val)

    def __init__(self, targetList, isMinheap=True):
        self.isMinheap = isMinheap
        for element in targetList:
            self.insertNode(element)


def heapSort(target, isAscending=True):
    '''
    heap sort. construct heap and pop it and push list.
    '''
    if isAscending:
        sortHeap = heap(target)
    else:
        sortHeap = heap(target, False)
    sortedList = []
    for i in range(len(target)):
        sortedList.append(sortHeap.popRoot())
    return sortedList


def main():
    testCase = [2, 6, 4, 8, 1, 9, 3, 10, 14, -4, 9396, 10205, -100]

    print("original:", testCase)
    print("heapSorted:", heapSort(testCase, True))


if __name__ == '__main__':
    main()
