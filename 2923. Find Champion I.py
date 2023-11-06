class Solution(object):
    def findChampion(self, grid):
        for i, l in enumerate(grid):
            s = sum(l)
            if s == len(grid) - 1 and grid[i][i] == 0:
                return i
        return -1
