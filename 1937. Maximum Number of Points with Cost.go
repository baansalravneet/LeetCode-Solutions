func maxPoints(points [][]int) int64 {
    n, m := len(points), len(points[0])
    dp := make([][]int, n)
    for i := range dp {
        dp[i] = make([]int, m)
    }
    for i := range dp[0] {
        dp[0][i] = points[0][i]
    }
    for i := 1; i < n; i++ {
        runningMaxLeft, runningMaxRight := dp[i-1][0], dp[i-1][m-1]
        for left, right := 0, m-1; left < m && right >= 0; left, right = left+1, right-1 {
            runningMaxLeft = max(dp[i-1][left], runningMaxLeft-1)
            runningMaxRight = max(dp[i-1][right], runningMaxRight-1)
            dp[i][left] = max(dp[i][left], points[i][left] + runningMaxLeft)
            dp[i][right] = max(dp[i][right], points[i][right] + runningMaxRight)
        }
    }
    var answer int64 = 0
    for _, v := range dp[n -1] {
        answer = max(answer, int64(v))
    }
    return answer
}

