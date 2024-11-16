class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower = [0] * 26
        upper = [0] * 26
        last_lower = [-1] * 26
        first_upper = [-1] * 26
        for i in range(len(word)):
            if word[i].islower():
                lower[ord(word[i]) - ord('a')] += 1
                last_lower[ord(word[i]) - ord('a')] = i
            else:
                upper[ord(word[i]) - ord('A')] += 1
                if first_upper[ord(word[i]) - ord('A')] == -1:
                    first_upper[ord(word[i]) - ord('A')] = i
        return sum([1 for i in range(26) if lower[i] > 0 and upper[i] > 0 and last_lower[i] < first_upper[i]])
        