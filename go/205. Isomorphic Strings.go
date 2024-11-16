func isIsomorphic(s string, t string) bool {
	mapping := make(map[byte]byte)
	used := make(map[byte]bool)
	for i := 0; i < len(s); i++ {
		if _, ok := mapping[s[i]]; !ok {
			if used[t[i]] {
				return false
			}
			mapping[s[i]] = t[i]
			used[t[i]] = true
		} else {
			if mapping[s[i]] != t[i] {
				return false
			}
		}
	}
	return true
}