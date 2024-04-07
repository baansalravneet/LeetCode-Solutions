func longestMonotonicSubarray(nums []int) int {
	answer, inc, dec := 1, 1, 1
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			inc += 1
			dec = 1
		} else if nums[i] < nums[i-1] {
			dec += 1
			inc = 1
		} else {
			inc = 1
			dec = 1
		}
		answer = max(answer, inc, dec)
	}
	return answer
}