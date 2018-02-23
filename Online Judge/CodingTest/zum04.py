from decimal import *

import math
import re

class RationalNumber:
    def __init__(self, num, denum):
        self.num = num
        self.denum = denum
        self.longDecimal = str()
        self.makeRelPrime()
        self.decimalRep = str()
        self.makeDecimalRep()

    def makeRelPrime(self):
        gcd = math.gcd(self.num, self.denum)
        while gcd != 1:
            self.num = self.num // gcd
            self.denum = self.denum // gcd
            gcd = math.gcd(self.num, self.denum)

    def makeDecimalRep(self):
        decimalRep = ""
        if self.isInteger():
            decimalRep = str(self.num // self.denum)
        elif self.isFiniteDecimal():
            decimalRep = str(self.num / self.denum)
        else:
            repeatPattern = self.getRepeatingPattern()
            startIndex = self.longDecimal.find(repeatPattern)
            decimalRep = self.longDecimal[0:startIndex]+"("+repeatPattern+")"
        self.decimalRep = decimalRep

    def getDecimalRep(self):
        return self.decimalRep

    def isInteger(self):
        if self.num % self.denum == 0:
            return True
        else:
            return False

    def isFiniteDecimal(self):
        denum = self.denum
        while denum % 2 == 0 or denum % 5 == 0:
            if denum % 2 == 0:
                denum = denum // 2
            elif denum % 5 == 0:
                denum = denum // 5
        if denum == 1:
            return True
        else:
            return False

    def getLongDecimal(self, maxLen):
        getcontext().prec = maxLen
        result = (Decimal(self.num) / Decimal(self.denum))
        self.longDecimal = str(result)

    def getRepeatingPattern(self):
        underPointRegex = re.compile("\.[0-9]*")
        maxPatternLen = self.denum - 1
        self.getLongDecimal(maxPatternLen * 4)
        decimal = self.longDecimal
        underPoint = underPointRegex.search(decimal).group()[1:]
        for index in range(len(underPoint)):
            startPoint = index
            lastLen = len(underPoint) - index
            for w in range(maxPatternLen+1):
                width = w+1
                substr = underPoint[startPoint : startPoint+width]
                nextsubStr = underPoint[startPoint + width : startPoint + (2 * width)]
                if nextsubStr == substr:
                    return substr

class DivideByZero(Exception):
    pass

def solution(A, B):
    rNum = RationalNumber(A, B)
    return rNum.getDecimalRep()




if __name__ == "__main__":
    # a = RationalNumber(2, 28)
    # print(a.num, a.denum)
    # underPointRegex = re.compile("\.[0-9]*")
    # decimal = str(format(3/28, "."+str(57)+"f"))
    # under = underPointRegex.search(decimal).group()[1:]
    # print(str(format(3/28, "."+str(57)+"f")))
    # print(2/28)
    # print(under)
    # print("ABCDBCD".find("BCD"))
    # print(math.gcd(2, 28))

    Aarray = [12, 1, 5, 1, 3, 1]
    Barray = [3, 2, 4, 3, 28, 19]
    for index in range(len(Aarray)):
        A = Aarray[index]
        B = Barray[index]
        print(solution(A, B))



