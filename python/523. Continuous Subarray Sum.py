class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        prefix_map = {}
        prefix_map[0] = -1
        current = 0
        for i in range(len(nums)):
            current += nums[i]
            current %= k
            if (current+k)%k in prefix_map and i-prefix_map[(current+k)%k]>=2:
                return True
            if current not in prefix_map:
                prefix_map[current] = i
        return False
