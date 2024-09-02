func chalkReplacer(chalk []int, k int) int {
	total := 0
	for _, v := range chalk {
		total += v
	}
	k %= total
	for i := 0; i < len(chalk); i++ {
		if chalk[i] > k {
			return i
		}
		k -= chalk[i]
	}
	return -1
}