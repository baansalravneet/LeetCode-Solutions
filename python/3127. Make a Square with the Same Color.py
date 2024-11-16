class Solution:
    def canMakeSquare(self, grid: List[List[str]]) -> bool:
        for i, j in [[0,0],[0,1],[1,0],[1,1]]:
            count = 0
            for x, y in [[0,0],[0,1],[1,0],[1,1]]:
                count += 1 if grid[i+x][j+y] == 'B' else 0
            if count != 2:
                return True
        return False