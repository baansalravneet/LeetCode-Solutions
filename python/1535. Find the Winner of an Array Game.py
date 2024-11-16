class Solution(object):
    def getWinner(self, arr, k):
        max_element = max(arr)
        current = arr[0]
        count = 0
        for i in range(1, len(arr)):
            if current == max_element or count == k:
                return current
            if current > arr[i]:
                count += 1
            else:
                current = arr[i]
                count = 1
        return current
