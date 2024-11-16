func minimumDiameterAfterMerge(edges1 [][]int, edges2 [][]int) int {
	d1, d2 := findDiameter(edges1), findDiameter(edges2)
	return max(d1, d2, (d1+1)/2 + (d2+1)/2 + 1)
}

func findDiameter(edges [][]int) int {
	adj := make([][]int, len(edges)+1)
	for _, edge := range edges {
		a, b := edge[0], edge[1]
		if adj[a] == nil {
			adj[a] = []int{}
		}
		if adj[b] == nil {
			adj[b] = []int{}
		}
		adj[a] = append(adj[a], b)
		adj[b] = append(adj[b], a)
	}
	farthestPoint, _ := findFar(adj, 0)
	_, distance := findFar(adj, farthestPoint)
	return distance
}

func findFar(adj [][]int, start int) (int, int) {
	length := 0
	visited := make([]bool, len(adj))
	q := newQueue()
	q.push(start)
	answer := -1
	for !q.empty() {
		size := q.len()
		for size > 0 {
			current := q.pop()
			size--
			if visited[current] {
				continue
			}
			visited[current] = true
			answer = current
			for _, next := range adj[current] {
				if !visited[next] {
					q.push(next)
				}
			}
		}
		length++
	}
	return answer, length-1
}

type queue []int

func newQueue() *queue {
	return &queue{}
}

func (q *queue) push(x int) {
	*q = append(*q, x)
}

func (q *queue) pop() int {
	x := (*q)[0]
	*q = (*q)[1:]
	return x
}

func (q *queue) len() int {
	return len(*q)
}

func (q *queue) empty() bool {
	return q.len() == 0
}
