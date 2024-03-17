class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        n = len(s)
        for i in range(1, n):
            a = s[i] + "" + s[i-1]
            if a in s:
                return True
        return False


