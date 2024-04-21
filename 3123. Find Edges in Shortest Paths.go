func findAnswer(n int, edges [][]int) []bool {
	graph := make(map[int][][2]int)
	for _, edge := range edges {
		u, v, w := edge[0], edge[1], edge[2]
		graph[u] = append(graph[u], [2]int{v, w})
		graph[v] = append(graph[v], [2]int{u, w})
	}
	distanceSource := findDistances(graph, 0, n)
	distanceTarget := findDistances(graph, n-1, n)
	answer := make([]bool, len(edges))
	for i, edge := range edges {
		u, v, w := edge[0], edge[1], edge[2]
		if distanceSource[u]+w+distanceTarget[v] == distanceSource[n-1] {
			answer[i] = true
		}
		if distanceSource[v]+w+distanceTarget[u] == distanceSource[n-1] {
			answer[i] = true
		}
	}
	return answer
}

func findDistances(graph map[int][][2]int, source, n int) []int {
	distance := make([]int, n)
	for i := range distance {
		distance[i] = math.MaxInt32
	}
	distance[source] = 0
	pq := make(PriorityQueue, 0)
	heap.Push(&pq, &Node{source, 0})
	for pq.Len() > 0 {
		node := heap.Pop(&pq).(*Node)
		u := node.val
		for _, edge := range graph[u] {
			v, w := edge[0], edge[1]
			if distance[u]+w < distance[v] {
				distance[v] = distance[u] + w
				heap.Push(&pq, &Node{v, distance[v]})
			}
		}
	}
	return distance
}

type Node struct {
	val      int
	distance int
}

type PriorityQueue []*Node

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool { return pq[i].distance < pq[j].distance }

func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	node := x.(*Node)
	*pq = append(*pq, node)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}