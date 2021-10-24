# Necro(ネクロ)
# sidmishra94540@gmail.com
def func(array, k):
    runSum = array[0]
    sumUpto = [runSum]
    for element in array[1:]:
        runSum = max(element, runSum+element)
        sumUpto.append(runSum)
    maxSum = sum(array[:k])
    currSum = maxSum
    for index, value in enumerate(array[k:]):
        currSum += array[index]-array[index-k]
        maxSum = max(maxSum, currSum)
        maxSum = max(maxSum, currSum+sumUpto[index-k])
    return maxSum