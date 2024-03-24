class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        answer = 0
        def find(s, start):
            freq = [0] * 26
            length = 0
            for i in range(start, len(s)):
                if freq[ord(s[i])-ord('a')] == 2:
                    return length
                freq[ord(s[i])-ord('a')] += 1
                length += 1
            return length
        for i in range(len(s)):
            answer = max(answer, find(s, i))
        return answer

