func climbStairs(n int) int {
    if n == 1 {
        return 1
    }
    if n == 2 {
        return 2
    }
    previous := 2
    previousPrevious := 1
    for i := 3; i <= n; i++ {
        next := previous + previousPrevious
        previousPrevious = previous
        previous = next
    }
    return previous
}
