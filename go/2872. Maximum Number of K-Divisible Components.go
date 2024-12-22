func maxKDivisibleComponents(n int, edges [][]int, values []int, k int) int {
	graph := getGraph(edges, n)
	result := make([]int, 1)
	dfs(0, -1, graph, values, k, result)
	return result[0]
}

func getGraph(edges [][]int, n int) [][]int {
	graph := make([][]int, n)
	for _, edge := range edges {
		from, to := edge[0], edge[1]
		graph[from] = append(graph[from], to)
		graph[to] = append(graph[to], from)
	}
	return graph
}

func dfs(current, parent int, graph [][]int, values []int, k int, result []int) int {
	sum := 0
	for _, next := range graph[current] {
		if next == parent {
			continue
		}
		sum += dfs(next, current, graph, values, k, result)
		sum %= k
	}
	sum += values[current]
	sum %= k
	if sum == 0 {
		result[0]++
	}
	return sum
}