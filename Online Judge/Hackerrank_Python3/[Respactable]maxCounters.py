import math

class MaxCounter:
    def __init__(self, N):
        self.counter = list(0 for i in range(N))
        self.N = N
        self.max = 0

    def processOperations(self, operations):
        for index in range(len(operations)):
            op = operations[index]
            if self.isIncreaseOperation(op):
                self.increaseOperation(op)
            else:
                self.maxOperation()

    def getLastMaxOpIndex(self, operations):
        opLen = len(operations)
        for index in range(opLen):
            reversedIndex = opLen - index - 1
            if self.isMaxOperation(operations[reversedIndex]):
                return reversedIndex
        raise NoMaxOperationException

    def increaseOperation(self, op):
        self.counter[op - 1] += 1

    def maxOperation(self):
        counterMax = max(self.counter)
        self.counter = list(counterMax for i in range(self.N))

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


class NoMaxOperationException(Exception):
    pass

def solution(N, A):
    maxcounter = MaxCounter(N)
    maxcounter.processOperations(A)
    return maxcounter.counter

if __name__ == "__main__":
    N = 5
    A = [3, 4, 4, 6, 1, 4, 4]
    answer = [3, 2, 2, 4, 2]
    print(solution(N, A))
