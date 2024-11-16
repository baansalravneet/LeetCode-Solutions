class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        answer = 0
        for i in range(k):
            answer += max(happiness[i] - i, 0)
        return answer