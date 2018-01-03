
def solution(X, A):
    leafSet = set()
    for index in range(len(A)):
        if A[index] <= X:
            leafSet.add(A[index])
            if len(leafSet) == X:
                return index
    return -1

if __name__ == "__main__":
    X = 5
    A = [1, 3, 1, 4, 2, 3, 5, 4]
    print(solution(X, A))