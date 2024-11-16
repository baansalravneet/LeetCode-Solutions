func subsetXORSum(nums []int) int {
	return sum(nums, 0, 0)
}
func sum(nums []int, index, current int) int {
	if index >= len(nums) {
		return current
	}
	return sum(nums, index+1, current) +
		sum(nums, index+1, nums[index]^current)
}