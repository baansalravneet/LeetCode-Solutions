class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        answer = inf
        for start in range(len(nums)):
            current = 0
            for end in range(start, len(nums)):
                current = current | nums[end]
                if end - start + 1 < answer and current >= k:
                    answer = end - start + 1
        return -1 if answer == inf else answer