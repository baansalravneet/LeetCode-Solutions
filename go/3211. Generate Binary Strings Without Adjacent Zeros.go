func validStrings(n int) []string {
	answer := []string{}
	find(&answer, "0", n-1)
	find(&answer, "1", n-1)
	return answer
}
func find(answer *[]string, current string, remaining int) {
	if remaining == 0 {
		*answer = append(*answer, current)
		return
	}
	find(answer, current+"1", remaining-1)
	if current[len(current)-1] == '1' {
		find(answer, current+"0", remaining-1)
	}
}