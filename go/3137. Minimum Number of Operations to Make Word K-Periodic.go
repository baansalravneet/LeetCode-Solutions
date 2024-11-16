func minimumOperationsToMakeKPeriodic(word string, k int) int {
	max_freq := 0
	freq := make(map[string]int)
	for i := 0; i < len(word); i += k {
		sub := word[i : i+k]
		if _, ok := freq[sub]; !ok {
			freq[sub] = 0
		}
		freq[sub] += 1
		max_freq = max(max_freq, freq[sub])
	}
	return len(word)/k - max_freq
}