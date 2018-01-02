
def getMinDiff(array:list):
    sum = getListSum(array)
    minDiff = 2000
    splitSum = 0
    for index in range(len(array)-1):
        splitSum += array[index]
        diff = abs(sum - 2*splitSum)
        if minDiff > diff:
            minDiff = diff
    return minDiff


def getListSum(array:list):
    return sum(array)

def solution(A):
    return getMinDiff(A)

if __name__ == "__main__":
    A = [1000, -1000]
    print(solution(A))