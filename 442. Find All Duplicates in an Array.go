func findDuplicates(nums []int) []int {
	answer := []int{}
	for i := range(nums) {
		val := nums[i]
        if val < 0 {
            val = -val
        }
        val -= 1
		if nums[val] < 0 {
			answer = append(answer, val+1)
		} else {
			nums[val] = -nums[val]
		}
	}
	return answer
}