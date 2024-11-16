class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        current, left, answer = 0, 0, 0
        for right in range(len(s)):
            current += abs(ord(s[right]) - ord(t[right]))
            while left <= right and current > maxCost:
                current -= abs(ord(s[left]) - ord(t[left]))
                left += 1
            answer = max(answer, right - left + 1)
        return answer
