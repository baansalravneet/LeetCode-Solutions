class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        q = deque([(0, 0, 0)])
        n, m = len(grid), len(grid[0])
        visited = [[False for i in range(m)] for j in range(n)]
        while q:
            x, y, cost = q.pop()
            if x == n-1 and y == m-1:
                return cost
            if visited[x][y]:
                continue
            visited[x][y] = True
            for i,(dx,dy) in enumerate([(0,1), (0,-1), (1,0), (-1,0)]):
                nx,ny = x+dx,y+dy
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                if visited[nx][ny]:
                    continue
                if grid[x][y] == i+1:
                    q.append((nx,ny,cost))
                else:
                    q.appendleft((nx,ny,cost+1))
        return -1
