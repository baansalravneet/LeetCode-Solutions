func countOfPairs(nums []int) int {
	maxValue := -1
	for _, v := range nums { maxValue = max(maxValue, v) }
	dp := make([][]int, len(nums))
	for i := range dp {
		dp[i] = make([]int, maxValue+1)
	}
	for i := 0; i <= nums[0]; i++ {
		dp[0][i] = 1
	}
	for index := 1; index < len(nums); index++ {
		for num1 := 0; num1 <= nums[index]; num1++ {
			num2 := nums[index]-num1
			for num1p := 0; num1p <= num1 && num1p <= nums[index-1]; num1p++ {
				if nums[index-1] - num1p >= num2 {
					dp[index][num1] += dp[index-1][num1p];
					dp[index][num1] %= int(1e9) + 7
				}
			}
		}
	}
	answer := 0
	for _, v := range dp[len(nums)-1] {
		answer += v
		answer %= int(1e9) + 7
	}
	return answer
}