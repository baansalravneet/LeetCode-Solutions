class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        mins = [[0]*m]*n
        mins[0][0] = grid[0][0]
        answer = float('-inf')
        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0: continue
                if j == 0:
                    answer = max(answer, grid[i][0] - mins[i-1][0])
                    mins[i][0] = min(mins[i-1][0], grid[i][0])
                elif i == 0:
                    answer = max(answer, grid[0][j] - mins[0][j-1])
                    mins[0][j] = min(mins[0][j-1], grid[0][j])
                else:
                    answer = max(answer, grid[i][j] - mins[i-1][j], grid[i][j] - mins[i][j-1])
                    mins[i][j] = min(mins[i-1][j], mins[i][j-1], grid[i][j])
        return answer