class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        total, max_element = (len(nums)*(len(nums)+1))//2, max(nums)
        left, count, answer = 0, 0, 0
        for right in range(len(nums)):
            if nums[right] == max_element:
                count += 1
            while count >= k:
                if nums[left] == max_element:
                    count -= 1
                left += 1
            answer += right - left + 1
        return total - answer
