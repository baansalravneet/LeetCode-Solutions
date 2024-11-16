class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        def dfs(curr_x, curr_y):
            nonlocal grid
            temp = grid[curr_x][curr_y]
            answer = 0
            grid[curr_x][curr_y] = 0
            for next_x, next_y in [(curr_x+1, curr_y), (curr_x-1, curr_y), (curr_x, curr_y+1), (curr_x, curr_y-1)]:
                if 0 <= next_x < len(grid) and 0 <= next_y < len(grid[0]) and grid[next_x][next_y] != 0:
                    answer = max(answer, dfs(next_x, next_y))
            grid[curr_x][curr_y] = temp
            return answer + temp
        answer = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    answer = max(answer, dfs(i, j))
        return answer