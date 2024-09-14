func longestSubarray(nums []int) int {
	m := nums[0]
	for _, v := range nums {
        m = max(m, v)
    }
	count, answer := 0, 1
	for _, v := range nums {
		if v == m {
			count++
		} else {
			count = 0
		}
		answer = max(answer, count)
	}
	return answer
}