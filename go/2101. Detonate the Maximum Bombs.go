func maximumDetonation(bombs [][]int) int {
    n := len(bombs)
    graph := make([][]int, n)
    for i := range graph {
        graph[i] = []int{}
    }
    for i := 0; i < n; i++ {
        for j := 0; j < n; j++ {
            if i != j && inRange(bombs[i], bombs[j]) {
                graph[i] = append(graph[i], j)
            }
        }
    }
    answer := 1
    for i := 0; i < n; i++ {
        answer = max(answer, dfs(graph, i, make([]bool, n)))
    }
    return answer
}

func dfs(graph [][]int, current int, visited []bool) int {
    count := 1
    visited[current] = true
    for _, i := range graph[current] {
        if visited[i] {
            continue
        }
        count += dfs(graph, i, visited)
    }
    return count
}

func inRange(a, b []int) bool {
    // returns true if b is in the range of a
    x1, y1, x2, y2 := a[0], a[1], b[0], b[1]
    return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) <= a[2]*a[2]
}

