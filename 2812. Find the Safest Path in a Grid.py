class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 1: return 0
        if grid[0][0] == 1 or grid[n-1][n-1] == 1: return 0
        min_distances = self.find_min(grid)
        left, right = 0, n*n
        answer = 0
        visited = set()
        while left <= right:
            mid = (left + right) // 2
            if self.can_do(min_distances, mid):
                answer = mid
                left = mid + 1
            else:
                right = mid - 1
        return answer
    def can_do(self, min_distances, limit):
        n = len(min_distances)
        if min_distances[0][0] < limit:
            return False
        if min_distances[n-1][n-1] < limit:
            return False
        visited = set()
        queue = deque([(0, 0)])
        while queue:
            x, y = queue.popleft()
            if x == n-1 and y == n-1:
                return True
            if (x, y) in visited:
                continue
            visited.add((x, y))
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited and min_distances[nx][ny] >= limit:
                    queue.append((nx, ny))
        return False
    def find_min(self, grid):
        n = len(grid)
        queue = deque()
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    queue.append((i, j))
        min_distances = [[0]*n for _ in range(n)]
        distance = 0
        visited = set()
        while queue:
            size = len(queue)
            while size > 0:
                x, y = queue.popleft()
                size -= 1
                if (x, y) in visited: continue
                visited.add((x, y))
                min_distances[x][y] = distance
                for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited:
                        queue.append((nx, ny))
            distance += 1
        return min_distances