func numberOfSpecialChars(word string) int {
	lower := [26]int{}
	upper := [26]int{}
	lastLower := [26]int{}
	firstUpper := [26]int{}
	for i := range 26 {
		lastLower[i] = -1
		firstUpper[i] = -1
	}
	for i, c := range word {
		if c >= 'a' && c <= 'z' {
			lower[c-'a']++
			lastLower[c-'a'] = i
		} else if c >= 'A' && c <= 'Z' {
			upper[c-'A']++
			if firstUpper[c-'A'] == -1 {
				firstUpper[c-'A'] = i
			}
		}
	}
	answer := 0
	for i := range 26 {
		if lower[i] > 0 && upper[i] > 0 && lastLower[i] < firstUpper[i] {
			answer++
		}
	}
	return answer
}