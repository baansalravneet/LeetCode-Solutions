class Solution:
    def getSmallestString(self, s: str, k: int) -> str:
        answer = ""
        for c in s:
            if k == 0:
                answer += c
                continue
            if k < ord('z')+1-ord(c):
                answer += chr(max(ord('a'), ord(c)-k))
                k = max(0, k-ord(c)+ord('a'))
            else:
                answer += 'a'
                if ord(c)-ord('a') < ord('z')+1-ord(c) and k >= ord(c)-ord('a'):
                    k -= ord(c)-ord('a')
                else:
                    k -= ord('z')+1-ord(c)
        return answer

