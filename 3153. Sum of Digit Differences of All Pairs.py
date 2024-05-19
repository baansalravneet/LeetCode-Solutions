class Solution:
    def sumDigitDifferences(self, nums: List[int]) -> int:
        freq = [[0]*10 for _ in range(9)]
        for n in nums:
            for i in range(9):
                x = 10**i
                digit = (n//x)%10
                freq[i][digit] += 1
        answer = 0
        for pos in range(9):
            for i in range(10):
                for j in range(i+1, 10):
                    answer += freq[pos][i]*freq[pos][j]
        return answer