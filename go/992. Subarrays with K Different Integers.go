func subarraysWithKDistinct(nums []int, k int) int {
	return find(nums, k) - find(nums, k-1)
}

func find(nums []int, k int) int {
	freq := make(map[int]int, len(nums))
	var unique, left, answer int
	for right := range nums {
		freq[nums[right]] += 1
		if freq[nums[right]] == 1 {
			unique += 1
		}
		for left <= right && unique > k {
			freq[nums[left]] -= 1
			if freq[nums[left]] == 0 {
				unique -= 1
			}
			left += 1
		}
		answer += right - left + 1
	}
	return answer
}