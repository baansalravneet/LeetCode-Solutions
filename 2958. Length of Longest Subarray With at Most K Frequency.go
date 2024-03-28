func maxSubarrayLength(nums []int, k int) int {
	freq := make(map[int]int)
	left := 0
	answer := 0
	for right := 0; right < len(nums); right++ {
		curr := nums[right]
		if _, ok := freq[curr]; !ok {
			freq[curr] = 0
		}
		freq[curr] += 1
		for left <= right && freq[curr] > k {
			freq[nums[left]] -= 1
			left += 1
		}
		answer = max(answer, right-left+1)
	}
	return answer
}