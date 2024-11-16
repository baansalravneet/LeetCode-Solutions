func countOfPairs(nums []int) int {
	maxValue := -1
	for _, v := range nums { maxValue = max(maxValue, v) }
	dp := make([][]int, len(nums))
	for i := range dp {
		dp[i] = make([]int, maxValue+1)
	}
	sum := 0
	for i := range dp[0] {
		if i <= nums[0] { sum++ }
		dp[0][i] = sum
	}
	for index := 1; index < len(nums); index++ {
		sum = 0
		for num1 := range dp[index] {
			pre := min(num1, nums[index-1], nums[index-1]-nums[index]+num1)
			if pre >= 0 && num1 <= nums[index] { sum += dp[index-1][pre] }
			sum %= int(1e9) + 7
			dp[index][num1] = sum
		}
	}
	return dp[len(nums)-1][maxValue]
}