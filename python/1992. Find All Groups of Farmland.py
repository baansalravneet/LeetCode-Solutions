class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        result = []
        def find_endpoints(row, col):
            nonlocal land
            i, j = row, col
            while i < len(land) and land[i][col] == 1:
                i += 1
            while j < len(land[0]) and land[row][j] == 1:
                j += 1
            for x in range (row, i):
                for y in range(col, j):
                    land[x][y] = 0
            return [row, col, i-1, j-1]
        for i in range(len(land)):
            for j in range(len(land[0])):
                if land[i][j] == 1:
                    result.append(find_endpoints(i, j))
        return result
