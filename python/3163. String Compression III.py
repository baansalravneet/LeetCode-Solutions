class Solution:
    def compressedString(self, word: str) -> str:
        answer = ""
        i = 0
        while i < len(word):
            count = 1
            while count < 9 and i + 1 < len(word) and word[i] == word[i + 1]:
                i += 1
                count += 1
            answer += str(count) + word[i]
            i += 1
        return answer