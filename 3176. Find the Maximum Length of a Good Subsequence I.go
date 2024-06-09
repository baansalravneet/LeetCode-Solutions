func maximumLength(nums []int, k int) int {
    dp := make([][]int, len(nums))
    for i := range dp {
        dp[i] = make([]int, k+1)
        for j := range dp[i] {
            dp[i][j] = 1
        }
    }
    answer := 0
    for x := 0; x <= k; x++ {
        for i := 0; i < len(nums); i++ {
            for j := 0; j < i; j++ {
                if nums[i] == nums[j] {
                    dp[i][x] = max(dp[i][x], 1+dp[j][x])
                } else if x > 0 {
                    dp[i][x] = max(dp[i][x], 1+dp[j][x-1])
                }
            }
            answer = max(answer, dp[i][x])
        }
    }
    return answer
}
