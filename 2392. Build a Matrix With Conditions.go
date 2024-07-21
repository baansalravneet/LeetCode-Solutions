func buildMatrix(k int, rowConditions [][]int, colConditions [][]int) [][]int {
    rowOrder := getOrder(getGraph(rowConditions, k), k)
    colOrder := getOrder(getGraph(colConditions, k), k)
    if len(rowOrder) == 0 || len(colOrder) == 0 {
        return [][]int{}
    }
    answer := make([][]int, k)
    for i := range answer {
        answer[i] = make([]int, k)
    }
    for i := 1; i <= k; i++ {
        answer[rowOrder[i]][colOrder[i]] = i
    }
    return answer
}

func getGraph(edges [][]int, k int) map[int][]int {
    graph := make(map[int][]int)
    for _, edge := range edges {
        from, to := edge[0], edge[1]
        if _, ok := graph[from]; !ok {
            graph[from] = []int{}
        }
        graph[from] = append(graph[from], to)
    }
    return graph
}

func getOrder(graph map[int][]int, k int) []int {
    inDegrees := make([]int, k+1)
    for i := 1; i <= k; i++ {
        if _, ok := graph[i]; !ok { continue }
        for _, x := range graph[i] {
            inDegrees[x]++
        }
    }
    q := []int{}
    for i := 1; i <= k; i++ {
        if inDegrees[i] == 0 {
            q = append(q, i)
        }
    }
    order := []int{}
    for len(q) > 0 {
        current := q[0]
        q = q[1:]
        order = append(order, current)
        if _, ok := graph[current]; !ok { continue }
        for _, next := range graph[current] {
            inDegrees[next]--
            if inDegrees[next] == 0 {
                q = append(q, next)
            }
        }
    }
    if len(order) != k {
        return []int{}
    }
    result := make([]int, k+1)
    index := 0
    for _, i := range order {
        result[i] = index
        index++
    }
    return result
}