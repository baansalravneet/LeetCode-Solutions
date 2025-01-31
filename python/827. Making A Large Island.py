class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        size_map = {}
        id = 2

        def flood_fill(x, y: int) -> int:
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[x]):
                return 0
            if not grid[x][y] or grid[x][y] == id:
                return 0
            grid[x][y] = id
            answer = 1
            for nx, ny in [(x+1, y), (x, y+1), (x-1, y), (x, y-1)]:
                answer += flood_fill(nx, ny)
            return answer

        answer = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if not grid[i][j]: continue
                if grid[i][j] != 1: continue
                size = flood_fill(i, j)
                answer = max(answer, size)
                size_map[id] = size
                id += 1

        for x in range(len(grid)):
            for y in range(len(grid[x])):
                if grid[x][y]: continue
                islands = set()
                for nx, ny in [(x+1, y), (x, y+1), (x-1, y), (x, y-1)]:
                    if nx < 0 or nx >= len(grid) or ny < 0 or ny >= len(grid[nx]) or not grid[nx][ny]:
                        continue
                    islands.add(grid[nx][ny])
                answer = max(answer, 1 + sum(size_map[i] for i in islands))

        return answer
