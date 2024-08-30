func modifiedGraphEdges(n int, edges [][]int, source int, destination int, target int) [][]int {
	graph := getGraph(n, edges)
	distance := run(n, graph, source, destination, target)
	if distance < target {
		return [][]int{}
	}
	matched := distance == target
	for i := 0; i < len(edges); i++ {
		if edges[i][2] != -1 {
			continue
		}
		edges[i][2] = 1
		if matched {
			edges[i][2] += target
		}
		from, to := edges[i][0], edges[i][1]
		graph[from] = append(graph[from], []int{to, edges[i][2]})
		graph[to] = append(graph[to], []int{from, edges[i][2]})
		if !matched {
			newDistance := run(n, graph, source, destination, target)
			if newDistance <= target {
				matched = true
				edges[i][2] += target - newDistance
			}
		}
	}
	if matched {
		return edges
	}
	return [][]int{}
}

func getGraph(n int, edges [][]int) [][][]int {
	graph := make([][][]int, n)
	for i := range graph {
		graph[i] = [][]int{}
	}
	for _, edge := range edges {
		from, to, weight := edge[0], edge[1], edge[2]
		if weight == -1 {
			continue
		}
		graph[from] = append(graph[from], []int{to, weight})
		graph[to] = append(graph[to], []int{from, weight})
	}
	return graph
}

func run(n int, graph [][][]int, source, destination, target int) int {
	pq := &minHeap{}
	heap.Init(pq)
	visited := make([]bool, n)
	heap.Push(pq, []int{source, 0})
	for pq.Len() > 0 {
		node := heap.Pop(pq).([]int)
		current, distance := node[0], node[1]
		if current == destination {
			return distance
		}
		if visited[current] {
			continue
		}
		visited[current] = true
		for _, next := range graph[current] {
			child, weight := next[0], next[1]
			if visited[child] {
				continue
			}
			heap.Push(pq, []int{child, distance + weight})
		}
	}
	return target + 1
}

type minHeap [][]int

func (h minHeap) Len() int            { return len(h) }
func (h minHeap) Less(i, j int) bool  { return h[i][1] < h[j][1] }
func (h minHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *minHeap) Push(x interface{}) { *h = append(*h, x.([]int)) }
func (h *minHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
