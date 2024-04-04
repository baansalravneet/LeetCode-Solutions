class Solution:
    def maxDepth(self, s: str) -> int:
        count, answer = 0, 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            elif s[i] == ')':
                count -= 1
            answer = max(answer, count)
        return answer

