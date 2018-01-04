


def solution(cars):
    passingCars = 0
    pairs = 0
    for car in cars:
        if car == 0:
            passingCars += 1
        else:
            pairs += passingCars
            if pairs > 1000000000:
                return -1
    return pairs


if __name__ == "__main__":
    A = [0, 1, 0, 1, 1]
    print(solution(A))