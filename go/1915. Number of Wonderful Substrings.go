func wonderfulSubstrings(word string) int64 {
	answer := 0
	freq := [1025]int{}
	freq[0] = 1
	curr := 0
	for _, w := range word {
		mask := 1 << (int(w) - int('a'))
		curr = curr ^ mask
		answer += freq[curr]
		for i := 0; i < 10; i++ {
			answer += freq[curr^(1<<i)]
		}
		freq[curr] += 1
	}
	return int64(answer)
}