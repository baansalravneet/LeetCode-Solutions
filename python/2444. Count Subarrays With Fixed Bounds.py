class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        answer, minI, maxI, badI = 0, -1, -1, -1
        for i in range(len(nums)):
            if nums[i] < minK or nums[i] > maxK:
                badI = i
            if nums[i] == minK:
                minI = i
            if nums[i] == maxK:
                maxI = i
            answer += max(0, min(minI, maxI) - badI)
        return answer
            