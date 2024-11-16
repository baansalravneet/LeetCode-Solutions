func minRemoveToMakeValid(s string) string {
	stack := []int{}
	unpaired := make(map[int]bool)
	for i, c := range s {
		if c == '(' {
			stack = append(stack, i)
		} else if c == ')' {
			if len(stack) == 0 {
				unpaired[i] = true
			} else {
				stack = stack[:len(stack)-1]
			}
		}
	}
	for _, i := range stack {
		unpaired[i] = true
	}
	res := []byte{}
	for i, c := range s {
		if _, ok := unpaired[i]; !ok {
			res = append(res, byte(c))
		}
	}
	return string(res)
}