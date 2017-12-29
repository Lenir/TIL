
# is arrival time is below 0, student arrived earlier. 

def angryProfessor(cancelThreshold, arrivalList):
    arrivedStudentNum = getArrivedStudent(arrivalList)
    isCanceled = (cancelThreshold > arrivedStudentNum)
    if isCanceled:
        return "YES"
    else:
        return "NO"

def getArrivedStudent(arrivalList:list):
    result = 0
    for arrival in arrivalList:
        if arrival <= 0:
            result += 1
    return result