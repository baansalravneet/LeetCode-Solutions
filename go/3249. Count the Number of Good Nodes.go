func countGoodNodes(edges [][]int) int {
	answer := 0
	graph := make(map[int][]int)
	for _, e := range edges {
		if _, ok := graph[e[0]]; !ok {
			graph[e[0]] = []int{}
		}
		if _, ok := graph[e[1]]; !ok {
			graph[e[1]] = []int{}
		}
		graph[e[0]] = append(graph[e[0]], e[1])
		graph[e[1]] = append(graph[e[1]], e[0])
	}
	var getCount func(map[int][]int, int, int) int
	getCount = func(graph map[int][]int, current, parent int) int {
		if _, ok := graph[current]; !ok {
			answer++
			return 1
		}
		previous, total, flag := -1, 0, true
		for _, next := range graph[current] {
			if next == parent { continue }
			count := getCount(graph, next, current)
			if previous == -1 { previous = count }
			if count != previous { flag = false }
			total += count
		}
		if flag { answer++ }
		return total + 1
	}
	getCount(graph, 0, -1)
	return answer
}