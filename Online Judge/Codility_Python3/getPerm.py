
def getSum(n:int):
    return ((n) * (n+1))//2

def getMissingElement(array):
    arrayLen = len(array)
    sum = getSum(arrayLen+1)
    for element in array:
        sum -= element
    return sum

def solution(A):
    return getMissingElement(A)

if __name__ == "__main__":
    A = [1, 3, 2, 5]
    print(solution(A))