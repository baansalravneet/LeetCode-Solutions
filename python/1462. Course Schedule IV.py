class Solution:
    def checkIfPrerequisite(self, n: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:

        graph = {}
        for edge in prerequisites:
            a, b = edge[0], edge[1]
            if a not in graph:
                graph[a] = []
            graph[a].append(b)

        is_reachable = [[False for _ in range(n)] for _ in range(n)]
        for i in range(n):
            q = deque([i])
            while q:
                current = q.popleft()
                if is_reachable[i][current]: continue
                is_reachable[i][current] = True
                if current not in graph: continue
                for next in graph[current]:
                    if is_reachable[i][next]: continue
                    q.append(next)

        answer = []
        for q in queries:
            a, b = q[0], q[1]
            answer.append(is_reachable[a][b])

        return answer