func productExceptSelf(nums []int) []int {
    n := len(nums)
    answer := make([]int, n)
    for i, _ := range(answer) {
        answer[i] = 1
    }
    left := 1
    right := 1
    for i := 0; i < n; i++ {
        answer[i] *= left
        answer[n-1-i] *= right
        left *= nums[i]
        right *= nums[n-1-i]
    }
    return answer
}
