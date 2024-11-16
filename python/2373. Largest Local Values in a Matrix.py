class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        answer = []
        for i in range(n-2):
            answer.append([])
            for j in range(n-2):
                val = grid[i][j]
                for x in range(3):
                    for y in range(3):
                        val = max(val, grid[i+x][j+y])
                answer[i].append(val)
        return answer
