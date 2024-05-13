class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        sIndex = [0]*26
        tIndex = [0]*26
        for i in range(len(s)):
            sIndex[ord(s[i])-ord('a')] = i
            tIndex[ord(t[i])-ord('a')] = i
        answer = 0
        for i in range(26):
            answer += abs(sIndex[i]-tIndex[i])
        return answer