func findPermutationDifference(s string, t string) int {
	sIndex := make([]int, 26)
	tIndex := make([]int, 26)
	for i := range len(s) {
		sIndex[s[i]-'a'] = i
		tIndex[t[i]-'a'] = i
	}
	answer := 0
	for i := range 26 {
		answer += abs(sIndex[i] - tIndex[i])
	}
	return answer
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}