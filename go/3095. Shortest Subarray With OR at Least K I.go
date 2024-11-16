func minimumSubarrayLength(nums []int, k int) int {
	answer := math.MaxInt32
	for start := range(nums) {
		current := 0
		for end := start; end < len(nums); end++ {
			current = current | nums[end]
			if current >= k && end - start + 1 < answer {
				answer = end - start + 1
			}
		}
	}
	if answer == math.MaxInt32 {
		return -1
	}
	return answer
}