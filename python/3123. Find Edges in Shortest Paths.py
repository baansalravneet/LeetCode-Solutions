class Solution:
    def findAnswer(self, n: int, edges: List[List[int]]) -> List[bool]:
        graph = {}
        for edge in edges:
            if edge[0] not in graph:
                graph[edge[0]] = []
            if edge[1] not in graph:
                graph[edge[1]] = []
            graph[edge[0]].append([edge[1], edge[2]])
            graph[edge[1]].append([edge[0], edge[2]])
        def find_distance(source, target):
            nonlocal graph, n
            distance = [int (1e9)] * n
            distance[source] = 0
            visited = set()
            pq = [(0, source)]
            while pq:
                dist, node = heapq.heappop(pq)
                if node in visited:
                    continue
                visited.add(node)
                if node not in graph:
                    continue
                for neighbor, weight in graph[node]:
                    if distance[neighbor] > distance[node] + weight:
                        distance[neighbor] = distance[node] + weight
                        heapq.heappush(pq, (distance[neighbor], neighbor))
            return distance
        distance_source = find_distance(0, n-1)
        distance_target = find_distance(n-1, 0)
        answer = [False] * len(edges)
        for i in range(len(edges)):
            u, v, w = edges[i]
            if distance_source[u] + w + distance_target[v] == distance_source[n-1]:
                answer[i] = True
            if distance_source[v] + w + distance_target[u] == distance_source[n-1]:
                answer[i] = True
        return answer


