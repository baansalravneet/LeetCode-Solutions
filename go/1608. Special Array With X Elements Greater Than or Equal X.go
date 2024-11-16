func specialArray(nums []int) int {
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if nums[i] >= len(nums)-i {
			if i == 0 || nums[i-1] < len(nums)-i {
				return len(nums) - i
			}
		}
	}
	return -1
}