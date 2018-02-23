
def getAlphabetList(word):
    alphabetList = [0]*26
    startIndex = ord('a')
    for char in word:
        charIndex = ord(char) - startIndex
        alphabetList[charIndex] += 1
    return alphabetList

def getDifference(word1, word2):
    word1List = getAlphabetList(word1)
    word2List = getAlphabetList(word2)
    diffSum = 0
    for index in range(26):
        diff = word1List[index] - word2List[index]
        diffSum += abs(diff)
    return diffSum


def solution(A, B):
    return getDifference(A, B)

if __name__ == "__main__":
    a = ["apple", "rather", "p"]
    b = ["pear", "harder", "p"]
    for index in range(len(a)):
        A = a[index]
        B = b[index]
        print(solution(A, B))