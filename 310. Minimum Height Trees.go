func findMinHeightTrees(n int, edges [][]int) []int {
	if n == 1 {
		return []int{0}
	}
	inDegree := make([]int, n)
	graph := make(map[int][]int)
	for _, edge := range edges {
		if _, ok := graph[edge[0]]; !ok {
			graph[edge[0]] = []int{}
		}
		if _, ok := graph[edge[1]]; !ok {
			graph[edge[1]] = []int{}
		}
		graph[edge[0]] = append(graph[edge[0]], edge[1])
		graph[edge[1]] = append(graph[edge[1]], edge[0])
		inDegree[edge[0]] += 1
		inDegree[edge[1]] += 1
	}
	q := []int{}
	for i, ins := range inDegree {
		if ins == 1 {
			q = append(q, i)
		}
	}
	for n > 2 {
		size := len(q)
		n -= size
		for i := 0; i < size; i++ {
			current := q[0]
			q = q[1:]
			inDegree[current] -= 1
			for _, next := range graph[current] {
				if inDegree[next] == 0 {
					continue
				}
				inDegree[next] -= 1
				if inDegree[next] == 1 {
					q = append(q, next)
				}
			}
		}
	}
	return q
}