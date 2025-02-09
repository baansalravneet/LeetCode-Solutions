class Solution:
    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for a, b in edges:
            graph[a-1].append(b-1)
            graph[b-1].append(a-1)

        groups = []
        colour = [0] * n
        def is_bipartite(i, c, group):
            if colour[i]: return colour[i] == c
            colour[i] = c
            group.append(i)
            return all(is_bipartite(neighbour, 3-c, group) for neighbour in graph[i])

        for i in range(n):
            if not colour[i]:
                group = []
                if not is_bipartite(i, 1, group): return -1
                groups.append(group)

        def bfs(node, visited):
            level = 0
            q = deque([node])
            while q:
                size = len(q)
                while size > 0:
                    size -= 1
                    current = q.popleft()
                    if visited[current]: continue
                    visited[current] = True
                    for neighbour in graph[current]:
                        if visited[neighbour]: continue
                        q.append(neighbour)
                level += 1
            return level

        return sum(max(bfs(i, [False]*n) for i in group) for group in groups)
