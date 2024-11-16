func shortestDistanceAfterQueries(n int, queries [][]int) []int {
	graph := make(map[int]int)
	for i := 0; i < n-1; i++ {
		graph[i] = i+1
	}
	answer := make([]int, len(queries))
	for i, q := range queries {
		from, to := q[0], q[1]
		if _, ok := graph[from]; !ok || graph[from] >= to {
			answer[i] = len(graph)
			continue
		}
		j := graph[from]
		for j < to {
			if next, ok := graph[j]; ok {
				delete(graph, j)
				j = next
			} else {
				break
			}
		}
        graph[from] = to
		answer[i] = len(graph)
	}
	return answer
}