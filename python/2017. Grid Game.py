class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        sum1, sum2, n = sum(grid[0]), 0, len(grid[0])
        min_value = float('inf')
        for i in range(n):
            sum1 -= grid[0][i]
            min_value = min(min_value, max(sum1, sum2))
            sum2 += grid[1][i]
        return min_value
