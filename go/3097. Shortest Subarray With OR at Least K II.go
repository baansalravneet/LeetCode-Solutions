func minimumSubarrayLength(nums []int, k int) int {
	freq := [32]int{}
	answer, left := math.MaxInt32, 0
	for right := range(nums) {
		add(&freq, nums[right])
		for get(&freq) >= k && left <= right {
			if answer > right - left + 1 {
				answer = right - left + 1
			}
			remove(&freq, nums[left])
			left++
		}
	}
	if answer == math.MaxInt32 {
		return -1
	}
	return answer
}
func add(freq *[32]int, num int) {
	for i := 0; i < 32; i++ {
		if num % 2 == 1 {
			freq[i] += 1
		}
		num /= 2
	}
}
func remove(freq *[32]int, num int) {
	for i := 0; i < 32; i++ {
		if num % 2 == 1 {
			freq[i] -= 1
		}
		num /= 2
	}
}
func get(freq *[32]int) int {
	answer := 0
	for i := 31; i >= 0; i-- {
		answer *= 2
		if freq[i] > 0 {
			answer += 1
		}
	}
	return answer
}