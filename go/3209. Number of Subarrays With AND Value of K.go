func countSubarrays(nums []int, k int) int64 {
	return count(nums, k) - count(nums, k+1)
}

func count(nums []int, k int) int64 {
	left := 0
	andValue := make([]int, 32)
	var count int64
	for right := 0; right < len(nums); right++ {
		add(andValue, nums[right])
		for left <= right && get(andValue, right-left+1) < k {
			remove(andValue, nums[left])
			left++
		}
		count += int64(right - left + 1)
	}
	return count
}

func add(andValue []int, k int) {
	for i := 0; i < 32; i++ {
		if (k & (1 << i)) > 0 {
			andValue[i]++
		}
	}
}

func get(andValue []int, count int) int {
	answer := 0
	for i := 0; i < 32; i++ {
		if andValue[i] == count {
			answer = answer | (1 << i)
		}
	}
	return answer
}

func remove(andValue []int, k int) {
	for i := 0; i < 32; i++ {
		if (k & (1 << i)) > 0 {
			andValue[i]--
		}
	}
}