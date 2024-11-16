class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        count = 0
        for i in range(0, len(s)):
            if s[i] == c:
                count += 1
        return (count * (count+1))//2
