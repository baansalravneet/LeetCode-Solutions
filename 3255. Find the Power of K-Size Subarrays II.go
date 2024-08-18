func resultsArray(nums []int, k int) []int {
    if k == 1 { return nums }
    result := make([]int, len(nums)-k+1)
    left := 0
    for right := 1; right < len(nums); right++ {
        if nums[right] != nums[right-1]+1 {
            for left < len(nums)-k+1 && left != right {
                result[left] = -1
                left++
            }
        }
        if right - left + 1 == k {
            result[left] = nums[right]
            left++
        }
    }
    return result
}

