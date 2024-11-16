func minimumSubstringsInPartition(s string) int {
	cache := make([]int, len(s))
	for i := range cache {
		cache[i] = -1
	}
	return helper(s, 0, cache)
}
func helper(s string, index int, cache []int) int {
	if index == len(s) {
		return 0
	}
	if cache[index] != -1 {
		return cache[index]
	}
	freq := make([]int, 26)
	answer := len(s)
	for i := index; i < len(s); i++ {
		freq[s[i]-'a']++
		if check(freq) {
			answer = min(answer, 1+helper(s, i+1, cache))
		}
	}
	cache[index] = answer
	return answer
}
func check(freq []int) bool {
	min, max := 100000, -1
	for _, f := range freq {
		if f == 0 {
			continue
		}
		if f < min {
			min = f
		}
		if f > max {
			max = f
		}
	}
	return min == max
}