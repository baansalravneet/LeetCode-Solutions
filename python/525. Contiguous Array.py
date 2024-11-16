class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        prefix = {0: -1}
        sum, answer = 0, 0
        for i in range(0, n):
            sum += 1 if nums[i] == 1 else -1
            if sum in prefix:
                answer = max(answer, i - prefix[sum])
            else:
                prefix[sum] = i
        return answer
