func numSubarrayProductLessThanK(nums []int, k int) int {
	answer, current, left := 0, 1, 0
	for right := range len(nums) {
		current *= nums[right]
		for current >= k && left <= right {
			current /= nums[left]
			left += 1
		}
		answer += right - left + 1
	}
	return answer
}