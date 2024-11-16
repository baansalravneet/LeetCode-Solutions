func subsets(nums []int) [][]int {
	var populate func(int)
	result := [][]int{}
	current := []int{}
	populate = func(index int) {
		if index >= len(nums) {
			result = append(result, append([]int{}, current...))
			return
		}
		populate(index + 1)
		current = append(current, nums[index])
		populate(index + 1)
		current = current[:len(current)-1]
	}
	populate(0)
	return result
}