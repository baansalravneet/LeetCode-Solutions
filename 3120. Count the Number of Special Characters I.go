func numberOfSpecialChars(word string) int {
	lower := [26]int{}
	upper := [26]int{}
	for _, c := range word {
		if c >= 'a' && c <= 'z' {
			lower[c-'a']++
		} else if c >= 'A' && c <= 'Z' {
			upper[c-'A']++
		}
	}
	answer := 0
	for i := 0; i < 26; i++ {
		if lower[i] > 0 && upper[i] > 0 {
			answer++
		}
	}
	return answer
}