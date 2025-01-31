class Solution:
    def minCost(self, n: int, cost: List[List[int]]) -> int:
        @cache
        def find_cost(idx, left, right):
            if idx >= n/2:
                return 0
            answer = float('inf')
            for i in range(3):
                for j in range(3):
                    if i == left or j == right or i == j:
                        continue
                    answer = min(answer, cost[idx][i]+cost[-idx-1][j]+find_cost(idx+1, i, j))
            return answer
        return find_cost(0, -1, -1)