func longestPalindrome(s string) int {
	freq := make([]int, 128)
	for _, i := range s {
		freq[i] += 1
	}
	answer := 0
	odd := false
	for _, i := range freq {
		if i%2 == 0 {
			answer += i
		} else {
			if odd {
				answer += i - 1
			} else {
				answer += i
				odd = true
			}
		}
	}
	return answer
}