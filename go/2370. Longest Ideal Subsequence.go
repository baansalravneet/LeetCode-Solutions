func longestIdealString(s string, k int) int {
	dp := [26]int{}
	answer := 1
	for _, ch := range s {
		c := int(ch) - 'a'
		left, right := max(0, c-k), min(25, c+k)
		for j := left; j <= right; j++ {
			dp[c] = max(dp[c], dp[j])
		}
		dp[c] += 1
		answer = max(answer, dp[c])
	}
	return answer
}