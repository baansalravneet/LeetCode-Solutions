func reverseParentheses(s string) string {
	stack := []int{}
	tele := make(map[int]int)
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			stack = append(stack, i)
		} else if s[i] == ')' {
			prev := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			tele[i] = prev
			tele[prev] = i
		}
	}
	direction, i := 1, 0
    var result strings.Builder
	for i < len(s) {
		if s[i] != '(' && s[i] != ')' {
			result.WriteByte(s[i])
		} else {
			direction = -direction
			i = tele[i]
		}
		i += direction
	}
	return result.String()
}