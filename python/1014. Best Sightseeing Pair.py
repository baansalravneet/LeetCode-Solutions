class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        runningMax = values[-1] - (len(values)-1)
        answer = float('-inf')
        for i in range(len(values)-2, -1, -1):
            answer = max(answer, runningMax + values[i] + i)
            runningMax = max(runningMax, values[i] - i)
        return answer