
def solution(array):
    array.sort()
    missed = 1
    for element in array:
        if element < missed:
            pass
        elif element == missed:
            missed += 1
        else:
            return missed
    return missed

if __name__ == "__main__":
    A = [1, 3, 6, 4, 1, 2]
    print(solution(A))