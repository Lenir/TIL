import math

def solution(A, B, K):
    if A == B:
        if A % K == 0:
            return 1
        else:
            return 0
    result = math.floor(B/K) - math.ceil(A/K) + 1
    return result

if __name__ == "__main__":
    A = 1
    B = 1
    K = 2
    print(solution(A, B, K))