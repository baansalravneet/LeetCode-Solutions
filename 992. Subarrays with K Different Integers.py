class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        def find(nums, k):
            freq = {}
            unique, answer, left = 0, 0, 0
            for right in range(len(nums)):
                if nums[right] not in freq:
                    freq[nums[right]] = 0
                freq[nums[right]] += 1
                if freq[nums[right]] == 1:
                    unique += 1
                while left <= right and unique > k:
                    freq[nums[left]] -= 1
                    if freq[nums[left]] == 0:
                        unique -= 1
                    left += 1
                answer += right - left + 1
            return answer
        return find(nums, k) - find(nums, k-1)

