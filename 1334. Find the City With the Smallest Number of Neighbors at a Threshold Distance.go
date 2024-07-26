func findTheCity(n int, edges [][]int, distanceThreshold int) int {
    graph := getGraph(edges, n)
    for k := 0; k < n; k++ {
        for i := 0; i < n; i++ {
            for j := 0; j < n; j++ {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
			}
		}
	}
	answer := -1
	minCities := n+1
	for i := 0; i < n; i++ {
		count := 0
		for j := 0; j < n; j++ {
			if graph[i][j] <= distanceThreshold {
				count++
			}
		}
        if answer == -1 || count <= minCities {
            answer = i
            minCities = count
        }
	}
    return answer
}

func getGraph(edges [][]int, n int) [][]int {
	graph := make([][]int, n)
	for i := range graph {
		graph[i] = make([]int, n)
		for j := range graph[i] {
			graph[i][j] = math.MaxInt32
		}
	}
	for _, edge := range edges {
		from, to, weight := edge[0], edge[1], edge[2]
		graph[from][to] = weight
		graph[to][from] = weight
	}
    for i := range graph {
        graph[i][i] = 0
    }
	return graph
}