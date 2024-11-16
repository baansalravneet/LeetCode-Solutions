func resultsArray(nums []int, k int) []int {
    result := make([]int, len(nums)-k+1)
    LOOP: for i := 0; i < len(nums)-k+1; i++ {
        for j := i+1; j < i+k; j++ {
            if nums[j] != nums[j-1]+1 {
                result[i] = -1
                continue LOOP
            }
        }
        result[i] = nums[i+k-1]
    }
    return result
}

