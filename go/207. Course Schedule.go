func canFinish(numCourses int, prerequisites [][]int) bool {
    inDegrees := make([]int, numCourses)
    adj := make([][]int, numCourses)
    q := []int{}
    for _, v := range prerequisites {
        inDegrees[v[0]]++
        if adj[v[1]] == nil {
            adj[v[1]] = make([]int, 0)
        }
        adj[v[1]] = append(adj[v[1]], v[0])
    }
    for i, v := range inDegrees {
        if v == 0 {
            q = append(q, i)
        }
    }
    count := 0
    for len(q) > 0 {
        current := q[0]
        count++
        q = q[1:]
        for _, next := range adj[current] {
            inDegrees[next]--
            if inDegrees[next] == 0 {
                q = append(q, next)
            }
        }
    }
    return count == numCourses
}
