import math

class GenomicSegmentTree:
    def __init__(self, S):
        self.segmentTree = self.getGenSegmentTree(S)


    def getGenSegmentTree(self, S):
        string = S
        if len(S) % 2 == 1:
            string = S + 'T'
        genIntList = self.genStringToIntList(string)
        segTree = list()
        segTree.append(genIntList)
        lowerSegment = genIntList
        while len(lowerSegment) > 1:
            segment = list()
            segments = math.ceil(len(lowerSegment) // 2)
            for index in range(segments):
                factors = lowerSegment[2 * index : 2 * index + 2]
                minFactor = self.getMinFactor(factors)
                segment.append(minFactor)
            segTree.append(segment)
            lowerSegment = segment
        # segTree.reverse()
        return segTree

    def genStringToIntList(self, string):
        result = list()
        for element in string:
            if element == 'A':
                result.append(1)
            elif element == 'C':
                result.append(2)
            elif element == 'G':
                result.append(3)
            else:
                result.append(4)
        return result

    def getMinFactor(self, factors):
        return min(factors)

    def getSubListByRange(self, start, end):
        result = list()
        factorizedRange = self.getFactorizedRange(start, end)
        for range in factorizedRange:
            rangeLevel = 0
            growable = True
            while growable:
                if math.pow(2, rangeLevel + 1) <= len(range):
                    rangeLevel += 1
                else:
                    growable = False
            rangeIndex = range[0] // len(range)
            result.append(self.segmentTree[rangeLevel][rangeIndex])
        return result

    def getMinFactorByRange(self, start, end):
        return min(self.getSubListByRange(start, end))

    def getFactorizedRange(self, start, end):
        result = list()
        localStart = start
        if localStart % 2 == 1:
            result.append([start])
            localStart += 1
        while localStart <= end:
            size = 1
            growable = True
            while growable:
                if localStart + (2 * size) <= end + 1 and localStart % (2*size) == 0:
                    size = size * 2
                else:
                    growable = False
            localList = list(i for i in range(localStart, localStart + size))
            if size == 0:
                break
            result.append(localList)
            localStart += size
        return result


def getGemMap(S):
    genMap = [[], [], []]
    for index in range(len(S)):
        char = S[index]
        if char == 'A':
            genMap[0].append(index)
        elif char == 'C':
            genMap[1].append(index)
        elif char == 'G':
            genMap[2].append(index)
        else:
            pass
    return genMap

def getMinFactor(genMap, start, end):
    impactFactor = 0
    for index in range(3):
        impactFactor = index + 1
        for genIndex in genMap[index]:
            if genIndex >= start and genIndex <= end:
                return impactFactor
    return 4


def solution(S, P, Q):
    queryLen = len(P)
    result = list()
    # genMap = getGemMap(S)
    segTree = GenomicSegmentTree(S)
    for index in range(queryLen):
        start = P[index]
        end = Q[index]
        result.append(segTree.getMinFactorByRange(start, end))
        # indexes = range(start, end)
        # minFactor = getMinFactor(genMap, start, end)
        # result.append(minFactor)
    return result


if __name__ == "__main__":
    S = "CAGCCTA"
    P = [2, 5, 0]
    Q = [4, 5, 6]
    print(solution(S, P, Q))
    # tree = GenomicSegmentTree(S)
    # print(tree.segmentTree)
    # print(tree.getMinFactorByRange(P[2], Q[2]))