class Solution:
    def minAnagramLength(self, s: str) -> int:
        len_sqrt = int(len(s) ** 0.5)
        answer = len(s)
        for i in range(1, len_sqrt + 1):
            if len(s) % i != 0:
                continue
            if self.check(s, i):
                answer = min(answer, i)
            if self.check(s, len(s) // i):
                answer = min(answer, len(s) // i)
        return answer

    def check(self, s, length):
        freq = [0] * 26
        size = 0
        for i in range(length):
            freq[ord(s[i]) - ord('a')] += 1
            if freq[ord(s[i]) - ord('a')] == 1:
                size += 1
        for i in range(length, len(s), length):
            newFreq = [0] * 26
            matched = 0
            for j in range(i, i+length):
                newFreq[ord(s[j]) - ord('a')] += 1
                if newFreq[ord(s[j]) - ord('a')] == freq[ord(s[j]) - ord('a')]:
                    matched +=1
            if matched != size:
                return False
        return True
