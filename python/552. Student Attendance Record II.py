class Solution:
    def checkRecord(self, n: int) -> int:
        cache = [[[-1]*3 for i in range(2)] for j in range(n)]
        return self.find(n, 0, 0, 0, cache)
    def find(self, n, length, count_a, previous_lates, cache):
        MOD = 1_000_000_007
        if count_a >= 2 or previous_lates >= 3: return 0
        if length >= n: return 1
        if cache[length][count_a][previous_lates] != -1:
            return cache[length][count_a][previous_lates]
        answer = 0
        answer += self.find(n, length+1, count_a+1, 0, cache)
        answer %= MOD
        answer += self.find(n, length+1, count_a, 0, cache)
        answer %= MOD
        answer += self.find(n, length+1, count_a, previous_lates+1, cache)
        answer %= MOD
        cache[length][count_a][previous_lates] = answer
        return answer