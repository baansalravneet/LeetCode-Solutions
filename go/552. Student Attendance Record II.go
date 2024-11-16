func checkRecord(n int) int {
	cache := make([][][]int, n, n)
	for i := range cache {
		cache[i] = make([][]int, 2, 2)
		for j := range cache[i] {
			cache[i][j] = make([]int, 3, 3)
			for k := range cache[i][j] {
				cache[i][j][k] = -1
			}
		}
	}
	return find(n, 0, 0, 0, cache)
}

func find(n, length, countA, previousLates int, cache [][][]int) int {
	MOD := 1_000_000_007
	if countA >= 2 || previousLates >= 3 {
		return 0
	}
	if length >= n {
		return 1
	}
	if cache[length][countA][previousLates] != -1 {
		return cache[length][countA][previousLates]
	}
	answer := 0
	answer += find(n, length+1, countA+1, 0, cache)
	answer %= MOD
	answer += find(n, length+1, countA, 0, cache)
	answer %= MOD
	answer += find(n, length+1, countA, previousLates+1, cache)
	answer %= MOD
	cache[length][countA][previousLates] = answer
	return answer
}