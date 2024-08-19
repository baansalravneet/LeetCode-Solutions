func minSteps(n int) int {
    if n == 1 { return 0 }
    cache := make([][]int, n)
    for i := range cache {
        cache[i] = make([]int, n)
        for j := range cache[i] {
            cache[i][j] = -1
        }
    }
    return 1 + helper(1, 1, n, cache)
}

func helper(current, buffer, n int, cache [][]int) int {
    if current == n { return 0 }
    if current+buffer > n { return 10000 }
    if cache[current][buffer] != -1 {
        return cache[current][buffer]
    }
    cache[current][buffer] = min(1+helper(current+buffer, buffer, n, cache), 2+helper(current+current, current, n, cache))
    return cache[current][buffer]
}
