func compressedString(word string) string {
	var sb strings.Builder
	for i := 0; i < len(word); {
		count := 0
		c := word[i]
		for i < len(word) && word[i] == c && count < 9 {
			count++
			i++
		}
		sb.WriteString(strconv.Itoa(count))
		sb.WriteString(string(c))
	}
	return sb.String()
}