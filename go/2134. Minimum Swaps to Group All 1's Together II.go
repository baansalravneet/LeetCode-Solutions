func minSwaps(nums []int) int {
	n, size, right, count, left := len(nums), 0, 0, 0, 0
	for _, v := range nums {
		size += v
	}
	for right < size {
		count += 1-nums[right]
		right++
	}
	answer := count
	for left < n {
		count += 1-nums[right%n]
		count -= 1-nums[left]
		right++
		left++
		answer = min(answer, count)
	}
	return answer
}