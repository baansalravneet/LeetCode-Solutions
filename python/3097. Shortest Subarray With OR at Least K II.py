class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        def add(num):
            nonlocal freq
            for i in range(32):
                if num % 2 == 1:
                    freq[i] += 1
                num //= 2
        def remove(num):
            nonlocal freq
            for i in range(32):
                if num % 2 == 1:
                    freq[i] -= 1
                num //= 2
        def get():
            nonlocal freq
            ans = 0
            for i in range(31, -1, -1):
                ans *= 2
                if freq[i] > 0:
                    ans += 1
            return ans
        freq = [0] * 32
        answer, left = float('inf'), 0
        for right in range(len(nums)):
            add(nums[right])
            while get() >= k and left <= right:
                answer = min(answer, right - left + 1)
                remove(nums[left])
                left += 1
        return answer if answer != float('inf') else -1
    

