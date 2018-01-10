

def getMinAverageSliceIndex(array):
    index = 0
    sums = [0] * len(array)
    minAverage = (array[0] + array[1]) / 2
    minIndex = 0
    for element in array:
        for sumIndex in range(index+1):
            sums[sumIndex] += element
            average = sums[sumIndex] / (index + 1 - sumIndex)
            if index >= sumIndex + 1:
                if average < minAverage:
                    minAverage = average
                    minIndex = sumIndex
                    print(sumIndex)
        index += 1
        print(sums, minAverage)
    return minIndex


def solution(A):
    return getMinAverageSliceIndex(A)

if __name__ == "__main__":
    A = [4, 2, 2, 5, 1, 5, 8]
    a = [4, 6, 8, 13, 14, 19, 27]
    print(solution(A))
    A = [3, 3, -30, -20, 10]
    print(solution(A))