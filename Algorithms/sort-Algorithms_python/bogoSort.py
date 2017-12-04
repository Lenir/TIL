import random
funcRun = 0


def bogoSort(target, isAscending=True):
    '''
    bogo sort.
    ramdomly re-arrange list and check it arranged.
    if list is arranged, bogo wort is done. if not, randomly re-arrange again.
    '''
    isSorted = False
    listLen = len(target)
    global funcRun
    funcRun = 0
    while not isSorted:
        # loop til list is sorted.
        # shuffle list
        funcRun += 1
        random.shuffle(target)
        # print(target)
        if isAscending:
            # check list is sorted - asc
            for index in range(listLen - 1):
                if target[index] > target[index + 1]:
                    break
                else:
                    if index is listLen - 2:
                        isSorted = True
                    pass
        else:
            # check list is sorted - desc
            for index in range(listLen - 1):
                if target[index] < target[index + 1]:
                    break
                else:
                    if index is listLen - 2:
                        isSorted = True
                    pass
    # print("sorted in", funcRun, "shuffles")
    return target


def main():
    global funcRun
    testCase = [3647, 11, 123, 2424, 8, 1, 35, 26, 20, 10]
    print("original :", testCase)
    testCase_asc = bogoSort(testCase).copy()
    print("bogoSorted(asc) in", funcRun, "shuffles :", testCase_asc)
    testCase_desc = bogoSort(testCase, False).copy()
    print("bogoSorted(desc) in", funcRun, "shuffles :", testCase_desc)


if __name__ == '__main__':
    main()
