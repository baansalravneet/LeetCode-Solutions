func reversePrefix(word string, ch byte) string {
	index := strings.Index(word, string(ch))
	if index == -1 {
		return word
	}
	return reverse(word[:index+1]) + word[index+1:]
}
func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}