
def getMaxLenQuasi(A:list):
    A.sort()
    lastLen = 0
    curLen = 0
    maxLen = 0
    curElement = A[0]
    for element in A:
        if isSameElement(curElement, element):
            curLen += 1
        elif isContinous(curElement, element):
            # continous. eg. 6, 7
            curMax = lastLen + curLen
            if maxLen < curMax:
                maxLen = curMax
            lastLen = curLen
            curLen = 1
            curElement = element
        else:
            # not continous. eg) 6, 8, 8
            curMax = lastLen + curLen
            if maxLen < curMax:
                maxLen = curMax
            lastLen = 0
            curLen = 1
            curElement = element
    return maxLen

def isContinous(curElement, element):
    if element == curElement + 1:
        return True
    else:
        return False

def isSameElement(curElement, element):
    if element == curElement:
        return True
    else:
        return False

def solution(A):
    return getMaxLenQuasi(A)

if __name__ == "__main__":
    A = [6,6,6,8,9,10]
    print(solution(A))