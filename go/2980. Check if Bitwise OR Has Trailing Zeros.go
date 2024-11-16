func hasTrailingZeros(nums []int) bool {
    countEven := 0
    for _, i := range nums {
        if i % 2 == 0 {
            countEven++
        }
        if countEven >= 2 {
            return true
        }
    }
    return false
}
