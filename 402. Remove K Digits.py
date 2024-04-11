class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        answer = []
        for c in num:
            while answer and answer[-1] > c and k:
                answer.pop()
                k -= 1
            answer.append(c)
        answer = answer[:-k] if k > 0 else answer
        return ''.join(answer).lstrip('0') or '0'
