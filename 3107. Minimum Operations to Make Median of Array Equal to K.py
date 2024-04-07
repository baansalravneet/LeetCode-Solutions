class Solution:
    def minOperationsToMakeMedianK(self, nums: List[int], k: int) -> int:
        nums.sort()
        mid = len(nums) // 2
        answer = 0
        if nums[mid] < k:
            for i in range(mid, len(nums)):
                if (nums[i] >= k):
                    break
                answer += k - nums[i]
        elif nums[mid] > k:
            for i in range(mid, -1, -1):
                if nums[i] <= k:
                    break
                answer += nums[i] - k
        return answer