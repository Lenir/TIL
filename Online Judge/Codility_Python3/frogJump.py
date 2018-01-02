def getMinJumps(X, Y, D):
    distance = Y - X
    if distance % D == 0:
        return distance // D
    else:
        return (distance // D) + 1

def solution(X, Y, D):
    return getMinJumps(X, Y, D)

if __name__ == "__main__":
    X = 10
    Y = 85
    D = 30
    print(solution(X, Y, D))