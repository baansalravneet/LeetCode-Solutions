class Solution:
    def numSteps(self, s: str) -> int:
        answer, carry = 0, 0
        for i in range(len(s) - 1, 0, -1):
            if s[i] == '1':
                if carry == 1:
                    answer += 1
                else:
                    answer += 2
                    carry += 1
            else:
                if carry == 1:
                    answer += 2
                else:
                    answer += 1
        if s[0] == '0':
            if carry == 0:
                answer += 1
        else:
            if carry == 1:
                answer += 1
        return answer