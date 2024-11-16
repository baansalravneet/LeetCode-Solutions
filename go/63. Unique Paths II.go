func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    n := len(obstacleGrid)
    m := len(obstacleGrid[0])
    dp := make([][]int, n+1)
    for i, _ := range dp {
        dp[i] = make([]int, m+1)
    }
    if obstacleGrid[0][0] != 1 {
        dp[1][1] = 1
    }
    for i := 1; i <= n; i++ {
        for j := 1; j <= m; j++ {
            if obstacleGrid[i-1][j-1] != 1 {
                dp[i][j] += dp[i-1][j] + dp[i][j-1]
            }
        }
    }
    return dp[n][m];
}
