func findNonMinOrMax(nums []int) int {
    if len(nums) < 3 {
        return -1
    }
    a, b, c := nums[0], nums[1], nums[2]
    if (a > b && b > c) || (c > b && b > a) {
        return b
    }
    if (b > a && a > c) || (c > a && a > b) {
        return a
    }
    return c
}
