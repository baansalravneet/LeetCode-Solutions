func occurrencesOfElement(nums []int, queries []int, x int) []int {
	answer := make([]int, len(queries))
	positions := []int{}
	for i := 0; i < len(nums); i++ {
		if nums[i] == x {
			positions = append(positions, i)
		}
	}
	for i := 0; i < len(queries); i++ {
		if queries[i] > len(positions) {
			answer[i] = -1
		} else {
			answer[i] = positions[queries[i]-1]
		}
	}
	return answer
}