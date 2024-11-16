class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        freq = {}
        left, answer = 0, 0
        for right in range(len(nums)):
            if nums[right] not in freq:
                freq[nums[right]] = 0
            freq[nums[right]] += 1
            while left <= right and freq[nums[right]] > k:
                freq[nums[left]] -= 1
                left += 1
            answer = right - left + 1 if answer < right - left + 1 else answer
        return answer
