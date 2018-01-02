import math

def getLongestZeroLen(binaryInt):
    strInt = str(binaryInt)
    maxLength = 0
    curLen = 0
    isInGap = False
    for char in strInt:
        if char == '1':
            isInGap = True
        else:
            pass
        if isInGap:
            if char == '0':
                curLen += 1
            else:
                if maxLength >= curLen:
                    pass
                else:
                    maxLength = curLen
                curLen = 0
    return maxLength

def solution(N):
    binary = bin(N)
    answer = getLongestZeroLen(binary)
    print(answer)

if __name__ == "__main__":
    solution(15)