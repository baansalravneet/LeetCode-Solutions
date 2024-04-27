func findRotateSteps(ring string, key string) int {
	index := make(map[byte][]int)
	cache := make([][]int, len(ring))
	for i, c := range ring {
		index[byte(c)] = append(index[byte(c)], i)
		cache[i] = make([]int, len(key))
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return helper(len(ring), key, 0, 0, index, cache)
}

func helper(n int, key string, i, currIndex int, index map[byte][]int, cache [][]int) int {
	if i == len(key) {
		return 0
	}
	if cache[currIndex][i] != -1 {
		return cache[currIndex][i]
	}
	answer := math.MaxInt32
	for _, next := range index[key[i]] {
		d := abs(currIndex - next)
		distance := min(d, n-d)
		answer = min(answer, distance+helper(n, key, i+1, next, index, cache))
	}
	cache[currIndex][i] = answer + 1
	return answer + 1
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}