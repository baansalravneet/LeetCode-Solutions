func getFinalState(nums []int, k int, multiplier int) []int {
    for i := 0; i < k; i++ {
        minValue, index := math.MaxInt32, -1
        for j := range nums {
            if nums[j] < minValue {
                minValue = nums[j]
                index = j
            }
        }
        nums[index] *= multiplier
    }
    return nums
}
