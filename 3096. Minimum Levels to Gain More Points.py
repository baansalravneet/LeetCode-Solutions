class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        total, sum = 0, 0
        for i in range(len(possible)):
            possible[i] = -1 if possible[i] == 0 else 1
            total += possible[i]
        for i in range(len(possible)-1):
            sum += possible[i]
            total -= possible[i]
            if sum > total:
                return i+1
        return -1