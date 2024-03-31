func countAlternatingSubarrays(nums []int) int64 {
	answer := int64(0)
	left := 0
	for right := 0; right < len(nums); {
		if right == left {
			answer += 1
			right += 1
		} else if nums[right] != nums[right-1] {
			answer += int64(right - left + 1)
			right += 1
		} else {
			left = right
		}
	}
	return answer
}