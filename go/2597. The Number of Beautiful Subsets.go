func beautifulSubsets(nums []int, k int) int {
	return find(nums, make([]int, 1001), k, 0) - 1
}

func find(nums, count []int, k, index int) int {
	if index >= len(nums) {
		return 1
	}
	answer := find(nums, count, k, index+1)
	condition := nums[index]+k >= len(count) || count[nums[index]+k] == 0
	condition = condition && (nums[index]-k < 0 || count[nums[index]-k] == 0)
	if condition {
		count[nums[index]] += 1
		answer += find(nums, count, k, index+1)
		count[nums[index]] -= 1
	}
	return answer
}
