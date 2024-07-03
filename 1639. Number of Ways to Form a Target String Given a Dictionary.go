func numWays(words []string, target string) int {
	wordLength := len(words[0])
	if len(target) > wordLength {
		return 0
	}
	db := make([][]int, wordLength)
	for i := range db {
		db[i] = make([]int, 26)
	}
	for i := 0; i < wordLength; i++ {
		for _, word := range words {
			index := int(word[i] - 'a')
			db[i][index]++
		}
	}
	cache := make([][]int, len(target))
	for i := range cache {
		cache[i] = make([]int, wordLength)
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	var find func(int, int, [][]int) int
	find = func(targetIndex, index int, cache [][]int) int {
		if targetIndex >= len(target) {
			return 1
		}
		if index >= wordLength {
			return 0
		}
		if cache[targetIndex][index] != -1 {
			return cache[targetIndex][index]
		}
		answer := find(targetIndex, index+1, cache)
		answer += db[index][int(target[targetIndex]-'a')] * find(targetIndex+1, index+1, cache)
		answer %= 1000000007
		cache[targetIndex][index] = answer
		return answer
	}
	return find(0, 0, cache)
}