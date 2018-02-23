

def countStrokes(A:list):
    strokeSum = 0
    lastHeight = 0
    for skyLine in A:
        heightDiff = skyLine - lastHeight
        if heightDiff > 0:
            strokeSum += heightDiff
        lastHeight = skyLine
        if strokeSum > 1000000000:
            raise MaximumHeightExceeds
    return strokeSum

class MaximumHeightExceeds(Exception):
    pass


def solution(A):
    try:
        result = countStrokes(A)
    except MaximumHeightExceeds:
        return -1
    return result


if __name__ == "__main__":
    a = [1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2]
    b = [5, 8]
    c = [2, 15, 1000000001]
    print(solution(a))
    print(solution(b))
    print(solution(c))