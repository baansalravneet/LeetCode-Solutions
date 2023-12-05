func maxSubArray(nums []int) int {
    currentSum := 0
    maxSum := math.MinInt32
    for _, i := range nums {
        maxSum = max(maxSum, i);
    }
    if maxSum <= 0 {
        return maxSum
    }
    for _, i := range nums {
        currentSum += i
        if currentSum < 0 {
            currentSum = 0
        }
        maxSum = max(currentSum, maxSum)
    }
    return maxSum
}
