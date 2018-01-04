
# def getSum(N):
#     return (N * (N+1)) // 2

def checkPerm(array:list):
    N = len(array)
    # sum = getSum(N)
    array.sort()
    for index in range(N):
        if index+1 != array[index]:
            return 0
    return 1


def solution(A):
    return checkPerm(A)

if __name__ == "__main__":
    A = [2, 1, 3, 4]
    print(solution(A))