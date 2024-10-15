class Solution:
    def minimumSteps(self, s: str) -> int:
        answer, index = 0, 0
        for i in range(len(s)):
            if s[i] == '0':
                answer += i - index
                index += 1
        return answer

