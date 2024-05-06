func isValid(word string) bool {
	vowelCount, consonantCount := 0, 0
	vowels := map[rune]bool{
		'a': true,
		'e': true,
		'i': true,
		'o': true,
		'u': true,
		'A': true,
		'E': true,
		'I': true,
		'O': true,
		'U': true,
	}
	for _, c := range word {
		if (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') {
			return false
		}
		if c >= '0' && c <= '9' {
			continue
		}
		if _, ok := vowels[c]; ok {
			vowelCount += 1
		} else {
			consonantCount += 1
		}
	}
	return len(word) >= 3 && vowelCount > 0 && consonantCount > 0
}