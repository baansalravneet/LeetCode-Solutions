class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        cost = [[0] * 10 for _ in range(m)]
        for j in range(m):
            freq = [0] * 10
            for i in range(n):
                freq[grid[i][j]] += 1
            for i in range(10):
                cost[j][i] = n - freq[i]
        @cached
        def helper(current, previous):
            nonlocal cost, m
            if current == m:
                return 0
            answer = float('inf')
            for i in range(10):
                if i == previous:
                    continue
                answer = min(answer, cost[current][i] + helper(current + 1, i))
            return answer
        return helper(0, -1)