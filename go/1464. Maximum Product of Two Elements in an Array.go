func maxProduct(nums []int) int {
    max1 := math.MinInt32
    max2 := math.MinInt32
    for _, v := range nums {
        if v > max1 {
            max2 = max1
            max1 = v
        } else if v > max2 {
            max2 = v
        }
    }
    return (max1 - 1)*(max2 - 1)
}
