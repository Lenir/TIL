
def radixNormalize(target):
    '''
    normalize list for use radix sort.
    returns zero-fill with maximum length in list.
    e.g) input list = [1,22,333,4444]
         output list = ['0001','0022','0333','4444']
    '''
    if target is None:
        return None
    else:
        maxLen = 0
        zeroFilled = []
        for element in target:
            # get maximum length in target element
            if maxLen < len(str(element)):
                maxLen = len(str(element))
        for element in target:
            # zero-fill
            zeroFilled.append(str(element).zfill(maxLen))
        return zeroFilled


def radixSort(target, radix=10, isAscending=True):
    '''
     radix sort. input is normalized with above func.(zero-filled string list)
    '''
    if target is None:
        return None
    else:
        sortedList = []
        elementLen = len(target[0])
        partialSorted = target
        for index in range(elementLen):
            # loop for element length.
            # first digit(rightmost[elementLen-1]) to last (leftmost, [0])
            radixSorted = []
            for index_b in range(radix):
                # build empty list in radix length
                radixSorted.append([])
            for element in partialSorted:
                '''
                loop in target list element.
                partial sort element in current digit value.
                '''
                curRadix = elementLen-index-1
                partIndex = element[curRadix]
                radixSorted[int(partIndex)].append(element)
            partialSorted = []
            if isAscending:
                for element in radixSorted:
                    # concatenate partial sorted list
                    partialSorted += element
            else:
                for element in reversed(radixSorted):
                    # concatenate partial sorted list
                    partialSorted += element
        for element in partialSorted:
            sortedList.append(int(element))
        return sortedList


def main():
    testCase = [3647, 11, 123, 2424, 2536, 1583, 1648, 1342, 12, 8]
    normalizedList = radixNormalize(testCase)
    print("original list:", testCase)
    print("RSorted list(desc):", radixSort(normalizedList, 10, False))
    print("RSorted list(asc):", radixSort(normalizedList))


if __name__ == '__main__':
    main()
