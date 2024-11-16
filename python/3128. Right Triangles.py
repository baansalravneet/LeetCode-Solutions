class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        colOnes = []
        rowOnes = []
        for i in range(len(grid)):
            count = 0
            for j in range(len(grid[i])):
                count += grid[i][j]
            rowOnes.append(count)
        for j in range(len(grid[0])):
            count = 0
            for i in range(len(grid)):
                count += grid[i][j]
            colOnes.append(count)
        answer = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if colOnes[j] <= 1 or rowOnes[i] <= 1 or grid[i][j] == 0:
                    continue
                answer += (colOnes[j]-1) * (rowOnes[i]-1)
        return answer