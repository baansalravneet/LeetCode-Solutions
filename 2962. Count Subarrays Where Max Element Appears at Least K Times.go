func countSubarrays(nums []int, k int) int64 {
	var result int64
	maxValue := 0
	for _, i := range nums {
		maxValue = max(maxValue, i)
	}
	count := 0
	for left, right := 0, 0; right < len(nums); right++ {
		if (nums[right] == maxValue) {
			count++
		}
		for count >= k {
			if nums[left] == maxValue {
				count--
			}
			left++
		}
		result += int64(left)
	}
	return result
}