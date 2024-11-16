func isArraySpecial(nums []int, queries [][]int) []bool {
	prefix := make([]int, len(nums))
	nums[0] = nums[0] % 2
	for i := 1; i < len(nums); i++ {
		nums[i] = nums[i] % 2
		if nums[i] != nums[i-1] {
			prefix[i] = 0
		} else {
			prefix[i] = 1
		}
		prefix[i] += prefix[i-1]
	}
	answer := make([]bool, len(queries))
	for i := 0; i < len(answer); i++ {
		left, right := queries[i][0], queries[i][1]
		if left == 0 {
			answer[i] = prefix[right] == 0
		} else {
			answer[i] = prefix[right] == prefix[left]
		}
	}
	return answer
}