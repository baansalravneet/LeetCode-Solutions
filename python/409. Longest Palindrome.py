class Solution:
    def longestPalindrome(self, s: str) -> int:
        answer = 0
        freq = [0] * 128
        for i in s:
            freq[ord(i)] += 1
        odd = False
        for i in freq:
            if i % 2 == 0: answer += i
            else:
                if odd:
                    answer += i-1
                else:
                    answer += i
                    odd = True
        return answer