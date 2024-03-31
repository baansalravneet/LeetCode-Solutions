func minimumLevels(possible []int) int {
	total, sum := 0, 0
	for i := range possible {
		if possible[i] == 0 {
			possible[i] = -1
		}
		total += possible[i]
	}
	for i := range len(possible)-1 {
		sum += possible[i]
		total -= possible[i]
		if sum > total {
			return i + 1
		}
	}
	return -1
}