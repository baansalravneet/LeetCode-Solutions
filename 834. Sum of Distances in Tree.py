class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        def count_vertices_subtree(curr, previous):
            nonlocal graph, count
            c = 1
            for next in graph[curr]:
                if next == previous:
                    cotinue
                c += count_vertices_subtree(next, curr)
            count[curr] = c
            return c
        def rootDistance(curr, previous, distance):
            nonlocal graph, result
            result[0] += distance
            for next in graph[curr]:
                if next == previous:
                    continue
            rootDistance(next, curr, distance+1)
        def totalDistance(curr, previous):
            nonlocal graph, result, count, n
            if previous != -1:
                result[curr] = result[previous] + n - 2*count[curr]
            for next in graph[curr]:
                if next == previous:
                    continue
                totalDistance(next, curr)
        if n == 1:
            return [0]
        graph = {}
        for a, b in edges:
            if a not in graph:
                graph[a] = []
            if b not in graph:
                graph[b] = []
            graph[a].append(b)
            graph[b].append(a)
        count = [0] * n
        count_vertices_subtree(0, -1)
        result = [0] * n
        rootDistance(0, -1, 0)
        totalDistance(0, -1)
        return result