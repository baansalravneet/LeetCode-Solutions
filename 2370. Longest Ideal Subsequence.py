class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        dp = [0]*26
        answer = 1
        for ch in s:
            c = ord(ch)-ord('a')
            left, right = max(0, c-k), min(25, c+k)
            for j in range(left, right):
                dp[c] = max(dp[c], dp[j])
            dp[c] += 1
            answer = max(answer, dp[c])
        return answer
