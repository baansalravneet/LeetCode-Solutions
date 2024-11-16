func scoreOfString(s string) int {
	answer := 0
	for i := 1; i < len(s); i++ {
		answer += abs(int(s[i]) - int(s[i-1]))
	}
	return answer
}
func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}