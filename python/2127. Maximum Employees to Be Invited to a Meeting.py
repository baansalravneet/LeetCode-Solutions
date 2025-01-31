class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        reversed_graph = [[] for _ in range(n)]
        for p in range(n):
            reversed_graph[favorite[p]].append(p)

        def _bfs(node: int, visited: set) -> int:
            q = deque([(node, 0)])
            max_distance = 0
            while q:
                current, distance = q.popleft()
                for neighbour in reversed_graph[current]:
                    if neighbour in visited: continue
                    visited.add(neighbour)
                    q.append((neighbour, distance + 1))
                    max_distance = max(max_distance, distance + 1)
            return max_distance

        longest_cycle, two_cycle = 0, 0
        visited = [False] * n
        for p in range(n):
            if visited[p]: continue
            distances = {}
            current = p
            distance = 0
            while True:
                if visited[current]: break
                visited[current] = True
                distances[current] = distance
                distance += 1
                neighbour = favorite[current]
                if neighbour in distances:
                    cycle_length = distance - distances[neighbour]
                    longest_cycle = max(longest_cycle, cycle_length)
                    if cycle_length == 2:
                        visited_nodes = {current, neighbour}
                        two_cycle += 2 + _bfs(neighbour, visited_nodes) + _bfs(current, visited_nodes)
                    break
                current = neighbour
        return max(longest_cycle, two_cycle)

