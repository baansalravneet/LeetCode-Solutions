func smallestDistancePair(nums []int, k int) int {
    sort.Ints(nums)
    n := len(nums)
    answer, left, right := 0, 0, nums[n-1] - nums[0]
	for left <= right {
		mid := (left + right) / 2
		count := getCount(nums, mid)
		if count < k {
			left = mid + 1
		} else {
			answer = mid
			right = mid - 1
		}
	}
	return answer
}

func getCount(nums []int, k int) int {
	answer, left := 0, 0
	for right := 0; right < len(nums); right++ {
		for nums[right] - nums[left] > k {
			left++
		}
		answer += right - left
	}
	return answer
}