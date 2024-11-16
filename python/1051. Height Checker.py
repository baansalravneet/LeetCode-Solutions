class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        copy = [i for i in heights]
        copy.sort()
        answer = 0
        for i in range(len(heights)):
            if copy[i] != heights[i]:
                answer += 1
        return answer
