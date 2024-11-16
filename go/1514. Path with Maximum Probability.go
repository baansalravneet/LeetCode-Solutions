func maxProbability(n int, edges [][]int, succProb []float64, start_node int, end_node int) float64 {
    graph := getGraph(edges, succProb)
    pq := &maxHeap{}
    heap.Init(pq)
    heap.Push(pq, newNode(start_node, 1))
    visited := make([]bool, n)
    for pq.Len() > 0 {
        curr := heap.Pop(pq).(node)
        if curr.val == end_node { return curr.prob }
        if visited[curr.val] { continue }
        visited[curr.val] = true
        if child, ok := graph[curr.val]; ok {
            for _, next := range child {
                if visited[next.val] { continue }
                heap.Push(pq, newNode(next.val, curr.prob * next.prob))
            }
        }
    }
    return 0
}

func getGraph(edges [][]int, succProb[]float64) map[int][]node {
    graph := make(map[int][]node)
    for i := 0; i < len(edges); i++ {
        to, from := edges[i][0], edges[i][1]
        prob := succProb[i]
        if _, ok := graph[from]; !ok {
            graph[from] = []node{}
        }
        if _, ok := graph[to]; !ok {
            graph[to] = []node{}
        }
        graph[from] = append(graph[from], newNode(to, prob))
        graph[to] = append(graph[to], newNode(from, prob))
    }
    return graph
}

func newNode(val int, prob float64) node {
    return node{val, prob}
}

type node struct {
    val int
    prob float64
}

type maxHeap []node


func (h maxHeap) Len() int           { return len(h) }
func (h maxHeap) Less(i, j int) bool { return h[i].prob > h[j].prob }
func (h maxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *maxHeap) Push(x any) {
	*h = append(*h, x.(node))
}

func (h *maxHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}