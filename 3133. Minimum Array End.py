class Solution:
    def minEnd(self, n: int, x: int) -> int:
        answer = 0
        pointer = 0
        n -= 1
        while x > 0 or n > 0:
            if (x%2) == 1:
                answer += (1 << pointer)
            else:
                if (n%2) == 1:
                    answer += (1 << pointer)
                n //= 2
            pointer += 1
            x //= 2
        return answer