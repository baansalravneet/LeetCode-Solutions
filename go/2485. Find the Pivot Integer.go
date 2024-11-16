func pivotInteger(n int) int {
    right := (n * (n + 1)) / 2
    left := 1
    for x := 1; x <= n; x++ {
        if right == left {
            return x
        }
        left += x+1
        right -= x
    }
    return -1
}
