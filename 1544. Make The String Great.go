func makeGood(s string) string {
	var stack []byte
	for i := 0; i < len(s); i++ {
		if len(stack) == 0 {
			stack = append(stack, s[i])
			continue
		}
		if checkSame(stack[len(stack)-1], s[i]) {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return string(stack)
}

func checkSame(a, b byte) bool {
	if a >= 'a' && a <= 'z' {
		return a-'a' == b-'A'
	}
	if a >= 'A' && a <= 'Z' {
		return a-'A' == b-'a'
	}
	return false
}