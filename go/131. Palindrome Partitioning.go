func partition(s string) [][]string {
	result := [][]string{}
	palindrome := func(s string) bool {
		for i := 0; i < len(s)/2; i++ {
			if s[i] != s[len(s)-1-i] {
				return false
			}
		}
		return true
	}
	var populate func(int, []string)
	populate = func(index int, current []string) {
		if index >= len(s) {
			result = append(result, append([]string{}, current...))
			return
		}
		for i := index; i < len(s); i++ {
			sub := s[index : i+1]
			if palindrome(sub) {
				current = append(current, sub)
				populate(i+1, current)
				current = current[:len(current)-1]
			}
		}
	}
	populate(0, []string{})
	return result
}