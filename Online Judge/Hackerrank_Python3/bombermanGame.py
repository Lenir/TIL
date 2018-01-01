
# input
# (row) (col) (sec)
# MAPs....

# eg. Input
# 6 7 3
# .......
# ...O...
# ....O..
# .......
# OO.....
# OO.....

# eg. Output
# OOO.OOO
# OO...OO
# OOO...O
# ..OO.OO
# ...OOOO
# ...OOOO

class bombermanArea:
    def __init__(self, initArea):
        self.area = list()
        self.setArea(initArea)
        self.row = len(self.area)
        self.col = len(self.area[0])
        self.parseIntInitBombs()
        self.curTime = 0
    #
    # def makeArea(self, rowNum, colNum):
    #     area = list()
    #     for row in range(rowNum):
    #         row = list()
    #         for col in range(colNum):
    #             row.append(".")
    #         area.append(row)
    #     return area

    def showArea(self):
        for row in self.area:
            for element in row:
                print(element, end='')
            print()

    def showAnswer(self):
        for row in self.area:
            for element in row:
                if element != '.':
                    print('O', end='')
                else:
                    print(element, end='')
            print()

    def setInitialArea(self, rowNum):
        area = self.getAreaFromStdin(rowNum)
        self.setArea(area)

    def setArea(self, areaList):
        self.area = areaList

    def getAreaFromStdin(self, rowNum):
        area = list()
        for index in range(rowNum):
            row = list()
            input(row)
            area.append(row)
        return area

    def parseIntInitBombs(self):
        for rowIndex in range(self.row):
            row = self.area[rowIndex]
            for index in range(self.col):
                element = row[index]
                if element == 'O':
                    self.area[rowIndex][index] = 0

    def plantBombs(self):
        for rowIndex in range(self.row):
            for index in range(self.col):
                if self.area[rowIndex][index] == '.':
                    self.area[rowIndex][index] = 0

    def countDownBombs(self):
        for rowIndex in range(self.row):
            for index in range(self.col):
                if self.area[rowIndex][index] != '.':
                    self.area[rowIndex][index] += 1
        self.detonateBombs()

    def detonateBombs(self):
        for rowIndex in range(self.row):
            row = self.area[rowIndex]
            for index in range(self.col):
                element = row[index]
                if element == 3:
                    self.markDistruct(rowIndex, index)
                    self.area[rowIndex][index] = '.'

    def markDistruct(self, row, col):
        upside = [row-1, col]
        downside = [row+1, col]
        leftSide = [row, col-1]
        rightSide = [row, col+1]
        sides = [upside, downside, leftSide, rightSide]
        for side in sides:
            rowNum = side[0]
            colNum = side[1]
            if self.isValidLoc(rowNum, colNum):
                try:
                    target = self.area[rowNum][colNum]
                    if target != 3:
                        self.area[rowNum][colNum] = '.'
                except:
                    print(side)
                    pass
            else:
                pass

    def isValidLoc(self, rowNum, colNum):
        if rowNum < 0 or colNum < 0 or rowNum >= self.row or colNum >= self.col:
            return False
        return True


    def passOneSec(self):
        self.curTime += 1
        self.countDownBombs()
        if self.curTime % 2 == 0:
            self.plantBombs()

    def passTimes(self, secs):
        for sec in range(secs):
            self.passOneSec()
            # self.showArea()
            # print()


if __name__ == "__main__":
    inputs = list(input().split(' '))
    initArea = list()
    for element in range(int(inputs[0])):
        initArea.append(list(input()))

    area = bombermanArea(initArea)
    area.passTimes(int(inputs[2]))
    area.showAnswer()