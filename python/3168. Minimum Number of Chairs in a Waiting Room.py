class Solution:
    def minimumChairs(self, s: str) -> int:
        answer, count = 0, 0
        for i in s:
            if i == 'E': count += 1
            else: count -= 1
            answer = max(answer, count)
        return answer

