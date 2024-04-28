class Solution:
    def medianOfUniquenessArray(self, nums: List[int]) -> int:
        n = len(nums)
        total = (n*(n+1))//2
        target = total//2 + (total%2)
        print(target)
        left, right = 1, n
        answer = 1
        while left <= right:
            mid = (left + right)//2
            count = self.get_count(nums, mid)
            if count >= target:
                answer = mid
                right = mid - 1
            else:
                left = mid + 1
        return answer
    def get_count(self, nums, k):
        count, freq, size, left = 0, {}, 0, 0
        for right in range(len(nums)):
            if nums[right] not in freq or freq[nums[right]] == 0:
                size += 1
                freq[nums[right]] = 0
            freq[nums[right]] += 1
            while size > k:
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    size -= 1
                left += 1
            count += right - left + 1
        return count
