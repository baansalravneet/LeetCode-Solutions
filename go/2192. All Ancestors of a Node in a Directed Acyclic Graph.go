func getAncestors(n int, edges [][]int) [][]int {
    result := make([][]int, n)
    adj := make([][]int, n)
    for i := range adj {
        adj[i] = []int{}
        result[i] = []int{}
    }
    for _, edge := range edges {
        from := edge[0]
        to := edge[1]
        adj[from] = append(adj[from], to)
    }
    for i := 0; i < n; i++ {
        dfs(i, i, adj, result)
    }
    return result
}

func dfs(current, ancestor int, graph, result [][]int) {
    for _, child := range graph[current] {
        if len(result[child]) == 0 || result[child][len(result[child])-1] != ancestor {
            result[child] = append(result[child], ancestor)
            dfs(child, ancestor, graph, result)
        }
    }
}

