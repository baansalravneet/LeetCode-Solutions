class Solution:
    def checkValidString(self, s: str) -> bool:
        open_count, close_count = 0, 0
        length = len(s)
        for i in range(0, length):
            if s[i] == '(' or s[i] == '*':
                open_count += 1
            else:
                open_count -= 1
            if s[-i-1] == ')' or s[-i-1] == '*':
                close_count += 1
            else:
                close_count -= 1
            if open_count < 0 or close_count < 0:
                return False
        return True

