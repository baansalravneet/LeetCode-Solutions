func duplicateNumbersXOR(nums []int) int {
	answer := 0
	for i := 0; i < len(nums); i++ {
		count := 0
		for j := i; j < len(nums); j++ {
			if nums[i] == nums[j] {
				count += 1
			}
		}
		if count > 1 {
			answer ^= nums[i]
		}
	}
	return answer
}