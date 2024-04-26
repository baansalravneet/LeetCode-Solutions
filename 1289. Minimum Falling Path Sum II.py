class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n, min1, min2, min1_i, min2_i = len(grid), 100, 100, -1, -1
        for i in range(n):
            if grid[0][i] < min1:
                min2, min2_i, min1, min1_i = min1, min1_i, grid[0][i], i
            elif grid[0][i] < min2:
                min2, min2_i = grid[0][i], i
        for i in range(1, n):
            m1, m2, m1_i, m2_i = inf, inf, -1, -1
            for j in range(n):
                next = grid[i][j] + (min1 if j != min1_i else min2)
                if next < m1:
                    m2, m2_i, m1, m1_i = m1, m1_i, next, j
                elif next < m2:
                    m2, m2_i = next, j
            min1, min2, min1_i, min2_i = m1, m2, m1_i, m2_i
        return min1