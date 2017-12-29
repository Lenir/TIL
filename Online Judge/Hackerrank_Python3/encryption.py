import math
# An English text needs to be encrypted using the following encryption scheme.
# First, the spaces are removed from the text. Let  be the length of this text.
# Then, characters are written into a grid, whose rows and columns have the following constraints: L


def encryption(s:str):
    # Complete this function
    strLen = len(s)
    rowSize = getRowSize(strLen)
    colSize = getColSize(strLen)
    rows = getSlice(s, colSize)
    rotated = getRotatedWords(rows)
    result = getRotatedListToStr(rotated)
    print(result)


def getSlice(s, colSize):
    result = list()
    index = 0
    while index < len(s):
        if index+colSize > len(s):
            result.append(s[index:])
        else:
            result.append(s[index:index+colSize])
        index += colSize
    return result

def getColSize(strLen):
    return math.ceil(math.sqrt(strLen))

def getRowSize(strLen):
    return math.floor(math.sqrt(strLen))

def getRotatedWords(rows):
    colSize = len(rows[0])
    result = list()
    for index in range(colSize):
        word = ""
        for row in rows:
            if len(row) >= index+1:
                word = word +row[index]
            else:
                pass
        result.append(word)
    return result

def getRotatedListToStr(rotated):
    result = ""
    for word in rotated:
        result = result + word + " "
    return result[:len(result)-1]

if __name__ == "__main__":
    encryption("haveaniceday")