func stoneGameII(piles []int) int {
	suffix := make([]int, len(piles))
	copy(suffix, piles)
	for i := len(piles)-2; i >= 0; i-- {
		suffix[i] += suffix[i+1]
	}
	cache := make([][]int, len(piles))
	for i := range cache {
		cache[i] = make([]int, len(piles))
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return helper(piles, 0, 1, suffix, cache)
}

func helper(piles []int, index, m int, suffix []int, cache [][]int) int {
	if index + 2*m >= len(piles) {
		return suffix[index]
	}
	if cache[index][m] != -1 { return cache[index][m] }
	answer := math.MaxInt32
	for i := 1; i <= 2*m; i++ {
		answer = min(answer, helper(piles, index+i, max(i, m), suffix, cache))
	}
	cache[index][m] = suffix[index] - answer
	return cache[index][m]
}