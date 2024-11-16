class Solution(object):
    def countAndSay(self, n):
        if n == 1:
            return "1"
        s = self.countAndSay(n-1)
        answer = ""
        i = 0
        while i < len(s):
            count = 0
            current = s[i]
            while i < len(s) and s[i] == current:
                i += 1
                count += 1
            answer += str(count) + current
        return answer
