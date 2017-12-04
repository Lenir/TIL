def selectionSort(target, isAscending=True):
    '''
    selection sort.
    select maximum(or minimum) element in list, and move it from list.
    and goes on.
    '''
    if target is None:
        return None
    else:
        listLen = len(target)
        sortedList = []
        for index in range(listLen):
            #loop for element number of target list.
            for i_search in range(listLen - index):
                if i_search is 0:
                    selectTarget = target[i_search]
                else:
                    if isAscending:
                        # search for minimum
                        if target[i_search] < selectTarget:
                            selectTarget = target[i_search]
                        else:
                            pass
                    else:
                        # search for maximum
                        if target[i_search] > selectTarget:
                            selectTarget = target[i_search]
                        else:
                            pass
            # move to partial sorted and remove it from original list.
            sortedList.append(selectTarget)
            target.remove(selectTarget)
        return sortedList


def main():
    testCase = [3647, 11, 123, 2424, 2536, 1583, 1648, 1342, 12, 8]
    testCase2 = testCase.copy()
    print("original :", testCase)
    print("selectionSorted(asc) :", selectionSort(testCase))
    print("selectionSorted(desc) :", selectionSort(testCase2,False))


if __name__ == '__main__':
    main()
