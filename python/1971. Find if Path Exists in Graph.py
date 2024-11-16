class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = {}
        for edge in edges:
            if edge[0] not in graph:
                graph[edge[0]] = []
            if edge[1] not in graph:
                graph[edge[1]] = []
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        return self.dfs(graph, source, destination, set())
    def dfs(self, graph, curr, destination, visited):
        if curr == destination:
            return True
        visited.add(curr)
        for neighbour in graph[curr]:
            if neighbour not in visited and dfs(graph, neighbour, destination, visited):
                return True
        return False
