func nextGreaterElements(nums []int) []int {
    n := len(nums)
    answer := make([]int, n)
    for i := range answer {
        answer[i] = -1
    }
    stack := make([]int, 0, n)
    for i := 0; i < 2*n; i++ {
        i := i % n
        for len(stack) > 0 && nums[stack[len(stack)-1]] < nums[i] {
            index := stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            if index >= len(answer) { continue }
            answer[index] = nums[i]
        }
        stack = append(stack, i)
    }
    return answer
}
