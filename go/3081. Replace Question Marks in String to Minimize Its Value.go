func minimizeStringValue(s string) string {
	freq := [26]int{}
	count := 0
	for i := range len(s) {
		if s[i] != '?' {
			freq[s[i]-'a']++
		} else {
			count++
		}
	}
	arr := []byte{}
	for i := 0; i < count; i++ {
		arr = append(arr, byte(find(&freq)))
	}
	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})
	index := 0
	answer := []byte{}
	for i := range len(s) {
		if s[i] == '?' {
			answer = append(answer, arr[index])
			index++
		} else {
			answer = append(answer, s[i])
		}
	}
	return string(answer)
}
func find(freq *[26]int) rune {
	min := 1000000
	minFreqCharacter := '?'
	for i := 0; i < 26; i++ {
		if freq[i] < min {
			min = freq[i]
			minFreqCharacter = rune(i + 'a')
		}
	}
	freq[minFreqCharacter-'a']++
	return minFreqCharacter
}