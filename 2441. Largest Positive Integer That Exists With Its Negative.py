class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        freq = [0] * 1001
        answer = -1
        for num in nums:
            if num < 0:
                freq[-num] += 1
        for num in nums:
            if num > 0 and freq[num] > 0 and answer < num:
                answer = num
        return answer
