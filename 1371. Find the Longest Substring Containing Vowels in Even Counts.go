func findTheLongestSubstring(s string) int {
	index := make(map[int]int)
	index[0] = -1
	current, answer := 0, 0
	for i := 0; i < len(s); i++ {
		if s[i] == 'a' { current ^= 1 }
		if s[i] == 'e' { current ^= 2 }
		if s[i] == 'i' { current ^= 4 }
		if s[i] == 'o' { current ^= 8 }
		if s[i] == 'u' { current ^= 16 }
		if v, ok := index[current]; ok {
			answer = max(answer, i - v)
		} else {
			index[current] = i
		}
	}
	return answer
}