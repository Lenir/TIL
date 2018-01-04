
def getGemMap(S):
    genMap = [[]*4]
    for index in range(len(S)):
        char = S[index]
        if char == 'A':
            genMap[0].append(index)
        elif char == 'C':
            genMap[1].append(index)
        elif char == 'G':
            genMap[2].append(index)
        else:
            genMap[3].append(index)
    return genMap

def getMinFactor(genMap, indexes):
    for index in range(4):
        pass


def solution(S, P, Q):
    queryLen = len(P)
    result = list()
    genMap = getGemMap(S)
    for index in range(queryLen):
        start = P[index]
        end = Q[index]+1
        indexes = range(start, end)
        minFactor = min(subString)
        if minFactor == 'A':
            result.append(1)
        elif minFactor == 'C':
            result.append(2)
        elif minFactor == 'G':
            result.append(3)
        else:
            result.append(4)
    return result


if __name__ == "__main__":
    S = "CAGCCTA"
    P = [2, 5, 0]
    Q = [4, 5, 6]
    print(solution(S, P, Q))
