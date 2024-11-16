func leastInterval(tasks []byte, n int) int {
	freq := [26]int{}
	for _, t := range tasks {
		freq[t-'A']++
	}
	sort.Ints(freq[:])
	maxFreq := freq[25] - 1
	idleSlots := maxFreq * n
	for i := 24; i >= 0 && freq[i] > 0; i-- {
		idleSlots -= min(maxFreq, freq[i])
	}
	return max(len(tasks), len(tasks)+idleSlots)
}