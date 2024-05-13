class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        answer = float('-inf')
        for i in range(len(energy)-1, len(energy)-1-k, -1):
            current_sum = 0
            for j in range(i, -1, -k):
                current_sum += energy[j]
                answer = max(answer, current_sum)
        return answer