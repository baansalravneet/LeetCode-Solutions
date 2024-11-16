class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        n, m, count = len(grid), len(grid[0]), 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    if i == 0:
                        count += 1
                    if j == 0:
                        count += 1
                    if i == n-1:
                        count += 1
                    if j == m-1:
                        count += 1
                    if i > 0 and grid[i-1][j] == 0:
                        count += 1
                    if j > 0 and grid[i][j-1] == 0:
                        count += 1
                    if i < n-1 and grid[i+1][j] == 0:
                        count += 1
                    if j < m-1 and grid[i][j+1] == 0:
                        count += 1
        return count
