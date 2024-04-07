func getSmallestString(s string, k int) string {
	newString := make([]byte, len(s))
	for i := range len(s) {
		newString[i], k = getChar(s[i], k)
	}
	return string(newString)
}
func getChar(c byte, k int) (byte, int) {
	if k == 0 {
		return c, k
	}
	if k < int('z')+1-int(c) {
		if k > int(c)-int('a') {
			return 'a', k - (int(c) - int('a'))
		}
		return byte(int(c) - k), 0
	}
	if int('z')-int(c)+1 > int(c)-int('a') {
		return 'a', k - (int(c) - int('a'))
	}
	return 'a', k - (int('z') - int(c) + 1)
}

