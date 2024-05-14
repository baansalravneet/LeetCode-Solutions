class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        rowFlips = [0]*n
        colFlips = [0]*m
        for i in range(n):
            if grid[i][0] == 0: rowFlips[i] += 1
        for j in range(1, m):
            count = 0
            for i in range(n):
                if (grid[i][j]+rowFlips[i])%2 != 0: count += 1
            if count <= n//2: colFlips[j] += 1
        for i in range(n):
            for j in range(m):
                grid[i][j] = (grid[i][j]+rowFlips[i]+colFlips[j])%2
        answer = 0
        for i in range(n):
            answer += self.getScore(grid[i])
        return answer
    def getScore(self, arr):
        answer = 0
        current = 1
        for i in range(len(arr)-1, -1, -1):
            answer += arr[i]*current
            current *= 2
        return answer
