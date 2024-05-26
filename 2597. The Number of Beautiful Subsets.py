class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        return self.find(nums, [0]*1001, k, 0)-1
    def find(self, nums, count, k, index):
        if index >= len(nums): return 1
        answer = self.find(nums, count, k, index+1)
        condition = nums[index]+k >= len(count) or count[nums[index]+k] == 0
        condition = condition and (nums[index]-k < 0 or count[nums[index]-k] == 0)
        if condition:
            count[nums[index]] += 1
            answer += self.find(nums, count, k, index+1)
            count[nums[index]] -= 1
        return answer