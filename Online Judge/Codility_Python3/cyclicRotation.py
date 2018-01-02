
def rotateArray(array, rotateNum):
    arrayLen = len(array)
    if arrayLen == 0:
        return array
    rotateNum = rotateNum % arrayLen

    rotatedArray = list()
    splitPoint = arrayLen - rotateNum

    rightShifted = array[:splitPoint]
    cycled = array[splitPoint:]
    rotatedArray = cycled + rightShifted
    return rotatedArray

def solution(A, K):
    return rotateArray(A, K)


if __name__ == "__main__":
    A = [3, 8, 9, 7, 6]
    K = 3
    print(solution(A, K))