
class GenomicPrefixSumMap:
    def __init__(self, S):
        self.prefixSumMap = self.getPrefixSumMap(S)

    def getPrefixSumMap(self, genomicString):
        result = [[], [], [], []]
        sums = [0, 0, 0, 0]
        for index in range(4):
            result[index].append(sums[index])
        for factor in genomicString:
            if factor == 'A':
                sums[0] += 1
            elif factor == 'C':
                sums[1] += 1
            elif factor == 'G':
                sums[2] += 1
            else:
                sums[3] += 1
            for index in range(4):
                result[index].append(sums[index])
        return result

    def getMinFactorInRange(self, start, end):
        startFactors = [self.prefixSumMap[index][start] for index in range(4)]
        endFactors = [self.prefixSumMap[index][end+1] for index in range(4)]
        print(startFactors, endFactors)
        for i in range(4):
            if startFactors[i] != endFactors[i]:
                return i + 1
        return 4


def solution(S, P, Q):
    queryLen = len(P)
    result = list()
    prefixSumMap = GenomicPrefixSumMap(S)
    for index in range(queryLen):
        start = P[index]
        end = Q[index]
        result.append(prefixSumMap.getMinFactorInRange(start, end))
    return result


if __name__ == "__main__":
    # S = "CAGCCTA"
    S = "GGGGGGG"
    P = [2, 5, 0, 0, 6, 3]
    Q = [4, 5, 6, 0, 6, 3]
    print(solution(S, P, Q))
    S = "G"
    P = [0]
    Q = [0]
    print(solution(S, P, Q))