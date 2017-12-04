qsortNum = 0


def findMedian(list):
    listLen = len(list)
    mid = int(listLen / 2)
    last = listLen - 1
    index = 0
    if list[0] > list[mid]:
        if list[last] > list[0]:
            index = 0
        elif list[mid] > list[last]:
            index = mid
        else:
            index = last
    elif list[last] > list[0]:
        if list[mid] > list[last]:
            index = last
        elif list[0] > list[mid]:
            index = 0
        else:
            index = mid
    return index


def findPivot(list):
    '''
    find median element in first, mid, last element.
    return median list element index.
    '''
    index = -1
    listLen = len(list)
    if listLen < 3:
        return 0
    else:
        index = findMedian(list)
        return index


def mergePartial(lessers, equals, largers, isAscending):
    if isAscending:
        return lessers + equals + largers
    else:
        return largers + equals + lessers


def quickSort(target, isAscending=True):
    '''
    if isAscending is True(default), sort ascending, if not, sort descending.
    Recursive function.
    '''
    # Recursion level
    global qsortNum
    qsortNum += 1
    listLen = len(target)
    if listLen == 0:
        return []
    elif listLen == 1:
        # end of partition QuickSort.
        return target
    else:
        pivot = target[findPivot(target)]
        lessers = []
        equals = []
        largers = []
        for element in target:
            if element > pivot:
                largers.append(element)
            elif element < pivot:
                lessers.append(element)
            else:
                equals.append(element)
        lessers = quickSort(lessers, isAscending)
        largers = quickSort(largers, isAscending)
        return mergePartial(lessers, equals, largers, isAscending)


def main():
    testCase = [2, 6, 4, 8, 1, 9, 3, 10]
    print("original:", testCase)
    print("qsorted:", quickSort(testCase, True))
    print("Sorted in", qsortNum, "Qsort functions")


if __name__ == '__main__':
    main()
