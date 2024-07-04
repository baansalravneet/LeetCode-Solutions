func largestPathValue(colors string, edges [][]int) int {
    n := len(colors)
    graph := getGraph(n, edges)
    topoOrder, success := getTopoOrder(n, graph)
	if !success { return -1 }
	if len(topoOrder) == 0 { return -1 }
    visited := make([]bool, n)
    cache := make([][]int, n)
    for i := range cache {
        cache[i] = make([]int, 26)
    }
    for _, node := range topoOrder {
        helper(n, graph, colors, visited, cache, node)
    }
    answer := 0
    for i := range cache {
        for j := range cache[i] {
            answer = max(answer, cache[i][j])
        }
    }
    return answer
}

func helper(n int, graph [][]int, colors string, visited []bool, cache[][]int, node int) {
    if visited[node] { return }
	visited[node] = true
	for _, next := range graph[node] {
		helper(n, graph, colors, visited, cache, next)
		for i := 0; i < 26; i++ {
			cache[node][i] = max(cache[node][i], cache[next][i])
		}
	}
	color := int(colors[node]-'a')
	cache[node][color]++
}

func getGraph(n int, edges [][]int) [][]int {
    graph := make([][]int, n)
    for i := range graph {
        graph[i] = []int{}
    }
    for _, edge := range edges {
        from, to := edge[0], edge[1]
        graph[from] = append(graph[from], to)
    }
    return graph
}

func getTopoOrder(n int, graph [][]int) ([]int, bool) {
	bfsQ := newQueue()
	inDegrees := make([]int, n)
	visited := make([]bool, n)
	answer := []int{}
	for i := range graph {
		for _, node := range graph[i] {
			inDegrees[node]++
		}
	}
	for i, v := range inDegrees {
		if v == 0 {
			bfsQ.push(i)
		}
	}
	for bfsQ.len() > 0 {
		current := bfsQ.pop()
		if visited[current] { continue }
		visited[current] = true
		answer = append(answer, current)
		for _, next := range graph[current] {
			if visited[next] { continue }
			inDegrees[next]--
			if inDegrees[next] == 0 {
				bfsQ.push(next)
			}
		}
	}
	return answer, n == len(answer)
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