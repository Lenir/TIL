

def getMinAverageSliceIndex(array):
    index = 0
    sums = [0] * len(array)
    minAverage = None
    minIndex = 0
    for element in array:
        for sumIndex in range(index+1):
            sums[sumIndex] += element
            average = sums[sumIndex] / (index + 1 - sumIndex)
            if sumIndex == 0 and index == 1:
                minAverage = average
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
    print(solution(A))
    A = [3, -20, -20, -20, 10]
    print(solution(A))