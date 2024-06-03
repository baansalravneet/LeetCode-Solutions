class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        freq = [0] * 32
        answer = float('inf')
        left = 0
        for right in range(len(nums)):
            self.add(freq, nums[right])
            curr = self.get(freq, right-left+1)
            answer = min(answer, abs(curr - k))
            while left <= right and curr < k:
                self.remove(freq, nums[left])
                left += 1
                curr = self.get(freq, right-left+1)
                answer = min(answer, abs(curr - k))
        return answer
    def add(self, freq, n):
        for i in range(32):
            if (n & (1 << i)) > 0:
                freq[i] += 1
    def remove(self, freq, n):
        for i in range(32):
            if (n & (1 << i)) > 0:
                freq[i] -= 1
    def get(self, freq, n):
        answer = 0
        for i in range(32):
            if freq[i] == n:
                answer ^= (1 << i)
        return answer
