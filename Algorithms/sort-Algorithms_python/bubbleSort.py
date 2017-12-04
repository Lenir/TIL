def bubbleSort(target, isAscending=True):
    '''
    bubble sort target.
    compare 1st, 2nd element, and swap(if condition is satisfied) and goes on n-1 to n.
    and cycle goes is 1st to n-1, 1st to n-2.... n times.
    '''
    if target is None:
        return None
    else:
        listLen = len(target)
        for index in range(listLen):
            # loop for 0 to listLen-1 n times.
            for i_cmp in range(listLen - index - 1):
                # loop for 0 to listLen-index-2 (compare with next element.)
                if isAscending:
                    # ascending sort
                    if target[i_cmp] > target[i_cmp + 1]:
                        # swap
                        target[i_cmp], target[i_cmp +
                                              1] = target[i_cmp + 1], target[i_cmp]
                    else:
                        pass
                else:
                    # descending sort
                    if target[i_cmp] > target[i_cmp + 1]:
                        pass
                    else:
                        # swap
                        target[i_cmp], target[i_cmp +
                                              1] = target[i_cmp + 1], target[i_cmp]
    return target


def main():
    testCase = [3647, 11, 123, 2424, 2536, 1583, 1648, 1342, 12, 8]
    print("original :", testCase)
    print("bubbleSorted(asc) :", bubbleSort(testCase))
    print("bubbleSorted(desc) :", bubbleSort(testCase, False))


if __name__ == '__main__':
    main()
