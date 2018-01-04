import math

class MaxCounter:
    def __init__(self, N):
        self.N = N
        self.counter = [0] * N
        self.max = 0
        self.nextMax = 0

    def initCounter(self, number:int):
        self.counter = [number] * (self.N)

    def processOperations(self, operations):
        maxOperated = False
        for index in range(len(operations)):
            op = operations[index]
            if self.isIncreaseOperation(op):
                self.increaseOperation(op)
                maxOperated = False
            elif not maxOperated:
                self.maxOperation()
                maxOperated = True
            else:
                pass

    def increaseOperation(self, op):
        if self.counter[op - 1] < self.max:
            self.counter[op - 1] = self.max
        self.counter[op - 1] += 1
        if self.nextMax < self.counter[op - 1]:
            self.nextMax = self.counter[op - 1]

    def maxOperation(self):
        self.max = self.nextMax

    def isIncreaseOperation(self, op):
        if op != self.N + 1:
            return True
        else:
            return False

    def isMaxOperation(self, op):
        if op == self.N + 1:
            return True
        else:
            return False

    def getResult(self):
        result = list()
        for element in self.counter:
            if element < self.max:
                result.append(self.max)
            else:
                result.append(element)
        return result


def solution(N, A):
    maxcounter = MaxCounter(N)
    maxcounter.processOperations(A)
    return maxcounter.getResult()

if __name__ == "__main__":
    N = 5
    A = [3, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 1, 4, 4]
    answer = [3, 2, 2, 4, 2]
    print(solution(N, A))
