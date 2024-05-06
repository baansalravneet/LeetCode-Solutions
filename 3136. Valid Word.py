class Solution:
    def isValid(self, word: str) -> bool:
        vowelCount, consonantCount = 0, 0
        for i in range(len(word)):
            c = word[i]
            if c in "aeiou" or c in "AEIOU":
                vowelCount += 1
            elif c in "bcdfghjklmnpqrstvwxyz" or c in "BCDFGHJKLMNPQRSTVWXYZ":
                consonantCount += 1
            elif c in "1234567890":
                pass
            else:
                return False
        return len(word) >= 3 and vowelCount > 0 and consonantCount > 0