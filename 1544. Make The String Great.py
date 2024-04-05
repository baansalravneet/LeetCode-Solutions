class Solution:
    def makeGood(self, s: str) -> str:
        stack = []
        for c in s:
            if not stack:
                stack.append(c)
                continue
            if self.checkSame(stack[-1], c):
                stack.pop()
            else:
                stack.append(c)
        return ''.join(stack)
    def checkSame(self, a, b):
        if ord(a) <= ord('Z') and ord(a) >= ord('A'):
            return ord(a) - ord('A') == ord(b) - ord('a')
        if ord(a) <= ord('z') and ord(a) >= ord('a'):
            return ord(a) - ord('a') == ord(b) - ord('A')
        return False