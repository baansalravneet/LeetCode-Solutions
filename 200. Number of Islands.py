class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        def floodFill(i, j):
            nonlocal grid
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
                return
            if grid[i][j] == '0':
                return
            grid[i][j] = '0'
            floodFill(i+1, j)
            floodFill(i, j+1)
            floodFill(i-1, j)
            floodFill(i, j-1)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    floodFill(i, j)
        return count