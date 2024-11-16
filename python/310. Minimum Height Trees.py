class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]
        graph = {}
        degrees = [0] * n
        for edge in edges:
            degrees[edge[0]] += 1
            degrees[edge[1]] += 1
            if edge[0] not in graph:
                graph[edge[0]] = []
            if edge[1] not in graph:
                graph[edge[1]] = []
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        q = []
        for i in range(len(degrees)):
            if degrees[i] == 1:
                q.append(i)
        while n > 2:
            size = len(q)
            n -= size
            for i in range(size):
                current = q.pop(0)
                degrees[current] -= 1
                for next in graph[current]:
                    if degrees[next] == 0:
                        continue
                    degrees[next] -= 1
                    if degrees[next] == 1:
                        q.append(next)
        return q