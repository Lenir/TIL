def mergeSort(target, isAscending=True):
    '''
    merge sort. divide lists til one element, and merge it sorting.
    '''
    listLen = len(target)
    partialList_1 = []
    partialList_2 = []
    sortedList = []
    if listLen > 2:
        # split list. and call recursive, and merge.
        splitPoint = (listLen//2)
        partialList_1 = mergeSort(target[0:splitPoint], isAscending)
        partialList_2 = mergeSort(target[splitPoint:], isAscending)
        partlen_1 = len(partialList_1)
        partlen_2 = len(partialList_2)
        if isAscending:
            partialList_1.reverse()
            partialList_2.reverse()
            while (partlen_1 > 0) or (partlen_2 > 0):
                if partlen_1 is 0:
                    sortedList.append(partialList_2.pop())
                elif partlen_2 is 0:
                    sortedList.append(partialList_1.pop())
                else:
                    if partialList_1[partlen_1-1] > partialList_2[partlen_2-1]:
                        sortedList.append(partialList_2.pop())
                    else:
                        sortedList.append(partialList_1.pop())
                partlen_1 = len(partialList_1)
                partlen_2 = len(partialList_2)
            return sortedList
        else:
            partialList_1.reverse()
            partialList_2.reverse()
            while (partlen_1 > 0) or (partlen_2 > 0):
                if partlen_1 is 0:
                    sortedList.append(partialList_2.pop())
                elif partlen_2 is 0:
                    sortedList.append(partialList_1.pop())
                else:
                    if partialList_1[partlen_1-1] < partialList_2[partlen_2-1]:
                        sortedList.append(partialList_2.pop())
                    else:
                        sortedList.append(partialList_1.pop())
                partlen_1 = len(partialList_1)
                partlen_2 = len(partialList_2)
            return sortedList
    elif listLen is 2:
        # compare and merge.
        if target[0] > target[1]:
            if isAscending:
                return [target[1], target[0]]
            else:
                return [target[0], target[1]]
        else:
            if isAscending:
                return [target[0], target[1]]
            else:
                return [target[1], target[0]]
    else:
        # 1 element.
        return target


def main():
    testCase = [2, 6, 4, 8, 1, 9, 3, 10, 14, -4, 9396, 10205, -100, 0]
    print("original:", testCase)
    print("mergeSorted(asc):", mergeSort(testCase, True))
    print("mergeSorted(desc):", mergeSort(testCase, False))


if __name__ == '__main__':
    main()
