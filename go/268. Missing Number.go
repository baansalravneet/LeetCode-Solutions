func missingNumber(nums []int) int {
    sum := 0
    for _, i := range(nums) {
        sum += i
    }
    n := len(nums)
    return (n*(n+1))/2 - sum
}
