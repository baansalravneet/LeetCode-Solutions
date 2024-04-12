func trap(height []int) int {
	answer := 0
	stack := []int{}
	for i := range height {
		for len(stack) > 0 && height[i] >= height[stack[len(stack)-1]] {
			h := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			if len(stack) > 0 {
				answer += (i - stack[len(stack)-1] - 1) * (min(height[i], height[stack[len(stack)-1]]) - h)
			}
		}
		stack = append(stack, i)
	}
	return answer
}