
def getUnpaired(array:list):
    sum = 0
    array.sort()
    for index in range((len(array)//2)):
        first = array[2*index]
        second = array[2*index + 1]
        if first != second:
            return first
    return array[len(array)-1]


def solution(A):
    return getUnpaired(A)


if __name__ == "__main__":
    a = [2, 3, 9, 3, 2, 9, 11]
    print(solution(a))