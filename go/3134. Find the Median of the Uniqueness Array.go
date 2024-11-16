func medianOfUniquenessArray(nums []int) int {
	n := len(nums)
	total := (n * (n + 1)) / 2
	left, right := 1, n
	answer := 1
	for left <= right {
		mid := (left + right) / 2
		count := checkCount(nums, mid)
		if count*2 >= total {
			answer = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return answer
}
func checkCount(nums []int, k int) int {
	answer := 0
	left := 0
	count := make(map[int]int)
	size := 0
	for right := range nums {
		count[nums[right]] += 1
		if count[nums[right]] == 1 {
			size += 1
		}
		for size > k {
			count[nums[left]] -= 1
			if count[nums[left]] == 0 {
				size -= 1
			}
			left += 1
		}
		answer += right - left + 1
	}
	return answer
}