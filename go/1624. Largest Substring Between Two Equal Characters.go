func maxLengthBetweenEqualCharacters(s string) int {
	leftIndex := make([]int, 26)
	rightIndex := make([]int, 26)
	n := len(s)
	for i := 0; i < n; i++ {
		rightIndex[s[i]-'a'] = i
		leftIndex[s[n-1-i]-'a'] = n - 1 - i
	}
	answer := -1
	for i := 0; i < 26; i++ {
		if rightIndex[i] == leftIndex[i] {
			continue
		}
		answer = max(answer, rightIndex[i]-leftIndex[i]-1)
	}
	return answer
}