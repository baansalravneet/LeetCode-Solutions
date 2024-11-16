class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def palindrome(s):
            for i in range(0, len(s)//2):
                if s[i] != s[-i-1]: return False
            return True
        def populate(index, current: List[str]):
            nonlocal result, s
            if index >= len(s):
                result.append(current.copy())
                return
            for i in range(index, len(s)):
                sub = s[index:i+1]
                if palindrome(sub):
                    current.append(sub)
                    populate(i+1, current)
                    current.pop()
        populate(0, [])
        return result