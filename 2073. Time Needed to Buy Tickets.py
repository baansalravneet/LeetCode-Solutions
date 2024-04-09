class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        answer = 0
        for i in range(len(tickets)):
            if i <= k:
                answer += min(tickets[i], tickets[k])
            else:
                answer += min(tickets[i], tickets[k]-1)
        return answer