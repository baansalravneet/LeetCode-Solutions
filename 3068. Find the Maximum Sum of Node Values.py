class Solution:
    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:
        n = len(nums)
        net_change = [0] * n
        sum = 0
        for i in range(n):
            net_change[i] = (nums[i]^k) - nums[i]
            sum += nums[i]
        net_change.sort()
        for i in range(n-1, 0, -2):
            if i == 0: break
            pair_sum = net_change[i] + net_change[i-1]
            if pair_sum > 0: sum += pair_sum
        return sum
