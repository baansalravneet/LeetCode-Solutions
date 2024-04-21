func validPath(n int, edges [][]int, source int, destination int) bool {
	graph := make(map[int][]int)
	for _, edge := range edges {
		graph[edge[0]] = append(graph[edge[0]], edge[1])
		graph[edge[1]] = append(graph[edge[1]], edge[0])
	}
	return dfs(graph, source, destination, make([]bool, n))
}
func dfs(graph map[int][]int, curr, destination int, visited []bool) bool {
	if curr == destination {
		return true
	}
	visited[curr] = true
	for _, next := range graph[curr] {
		if !visited[next] && dfs(graph, next, destination, visited) {
			return true
		}
	}
	return false
}

