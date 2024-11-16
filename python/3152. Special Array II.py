class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        prefix = [0] * len(nums)
        nums[0] = nums[0] % 2
        for i in range(1, len(nums)):
            nums[i] = nums[i] % 2
            prefix[i] = 0 if nums[i] != nums[i-1] else 1
            prefix[i] += prefix[i-1]
        answer = [False] * len(queries)
        for i in range(0, len(answer)):
            left, right = queries[i][0], queries[i][1]
            answer [i] = prefix[right] == 0 if left == 0 else prefix[right] == prefix[left]
        return answer