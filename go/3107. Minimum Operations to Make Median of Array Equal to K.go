func minOperationsToMakeMedianK(nums []int, k int) int64 {
	sort.Ints(nums)
	mid := len(nums) / 2
	var answer int64
	if nums[mid] < k {
		for i := mid; i < len(nums); i++ {
			if nums[i] >= k {
				break
			}
			answer += int64(k - nums[i])
		}
	} else if nums[mid] > k {
		for i := mid; i >= 0; i-- {
			if nums[i] <= k {
				break
			}
			answer += int64(nums[i] - k)
		}
	}
	return answer
}