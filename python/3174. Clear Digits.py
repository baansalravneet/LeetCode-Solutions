class Solution:
    def clearDigits(self, s: str) -> str:
        answer = ""
        for c in s:
            if ord(c) >= ord('0') and ord(c) <= ord('9'):
                answer = answer[:-1]
            else:
                answer += c
        return answer
