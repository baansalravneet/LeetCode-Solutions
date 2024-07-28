func secondMinimum(n int, edges [][]int, time int, change int) int {
	pq := make(priorityQueue, 0)
	heap.Init(&pq)
	dist := make([]int, n+1)
	for i := 0; i <= n; i++ {
		dist[i] = math.MaxInt32
	}
	updates := make([]int, n+1)
	heap.Push(&pq, node{1, 0})
	dist[1] = 0
	adj := getGraph(edges)
	for pq.Len() > 0 {
		cur := heap.Pop(&pq).(node)
		val, d := cur.val, cur.dist
		if updates[val] > 2 { continue }
		if val == n {
			if updates[val] == 2 { return dist[val] }
		}
		for _, next := range adj[val] {
			if updates[next] == 2 { continue }
			nextGreen := getNextGreen(d, change)
			if dist[next] != nextGreen + time {
				updates[next]++
				dist[next] = nextGreen + time
			}
			heap.Push(&pq, node{next, nextGreen + time})
		}
	}
	return -1
}

func getGraph(edges [][]int, n int) [][]int {
	graph := make([][]int, n+1)
	for i := range graph {
		graph[i] = []int{}
	}
	for _, edge := range edges {
		graph[edge[0]] = append(graph[edge[0]], edge[1])
		graph[edge[1]] = append(graph[edge[1]], edge[0])
	}
	return graph
}

func getNextGreen(current, change int) int {
	cycles := current / change;
	if cycles % 2 == 0 { return current }
	return (cycles + 1) * change
}

type node struct {
	val int
	dist int
}

type priorityQueue []node

func (p priorityQueue) Len() int {
	return len(p)
}

func (p priorityQueue) Less(i, j int) bool {
	return p[i].dist < p[j].dist
}

func (p priorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func (p *priorityQueue) Push(x interface{}) {
	*p = append(*p, x.(node))
}

func (p *priorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	x := old[n-1]
	*p = old[0:n-1]
	return x
}

