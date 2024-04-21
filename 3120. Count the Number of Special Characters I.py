class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower = [0] * 26
        upper = [0] * 26
        for c in word:
            if c.islower():
                lower[ord(c) - ord('a')] += 1
            elif c.isupper():
                upper[ord(c) - ord('A')] += 1
        return sum([1 for i in range(26) if lower[i] > 0 and upper[i] > 0])
