func sumOfDistancesInTree(n int, edges [][]int) []int {
	if n == 1 {
		return []int{0}
	}
	graph := make([][]int, n)
	for _, edge := range edges {
		a, b := edge[0], edge[1]
		graph[a] = append(graph[a], b)
		graph[b] = append(graph[b], a)
	}
	fmt.Println(graph)
	subtreeCount := make([]int, n)
	var getSubtreeCount func(int, int) int
	getSubtreeCount = func(curr, previous int) int {
		count := 1
		for _, next := range graph[curr] {
			if next == previous {
				continue
			}
			count += getSubtreeCount(next, curr)
		}
		subtreeCount[curr] = count
		return count
	}
	getSubtreeCount(0, -1)
	distance := make([]int, n)
	var rootDistance func(int, int, int)
	rootDistance = func(curr, previous, d int) {
		distance[0] += d
		for _, next := range graph[curr] {
			if next == previous {
				continue
			}
			rootDistance(next, curr, d+1)
		}
	}
	rootDistance(0, -1, 0)
	var finalDistance func(int, int)
	finalDistance = func(curr, previous int) {
		if previous != -1 {
			distance[curr] = distance[previous] + n - 2*subtreeCount[curr]
		}
		for _, next := range graph[curr] {
			if next == previous {
				continue
			}
			finalDistance(next, curr)
		}
	}
	finalDistance(0, -1)
	return distance
}