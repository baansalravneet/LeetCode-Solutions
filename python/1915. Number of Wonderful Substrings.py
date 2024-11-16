class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        curr = 0
        freq = [0]*1025
        freq[0] = 1
        answer = 0
        for w in word:
            mask = 1<<(ord(w)-ord('a'))
            curr = curr ^ mask
            answer += freq[curr]
            for i in range(10):
                answer += freq[curr ^ (1<<i)]
            freq[curr] += 1
        return answer