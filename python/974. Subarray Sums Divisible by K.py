class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        freq = {}
        freq[0] = 1
        answer, current = 0, 0
        for i in nums:
            current += i
            while current < 0:
                current += k
            current %= k
            if current not in freq:
                freq[current] = 0
            answer += freq[current]
            freq[current] += 1
        return answer
