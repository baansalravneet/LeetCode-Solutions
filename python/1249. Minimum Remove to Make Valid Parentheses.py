class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        unpaired = set()
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if stack:
                    stack.pop()
                else:
                    unpaired.add(i)
        unpaired.update(stack)
        return ''.join([c for i, c in enumerate(s) if i not in unpaired])
        