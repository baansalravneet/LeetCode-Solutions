func minHeightShelves(books [][]int, shelfWidth int) int {
	cache := make([][]int, len(books))
	for i := range cache {
		cache[i] = make([]int, shelfWidth+1)
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return helper(books, shelfWidth, 0, 0, 0, cache)
}

func helper(books [][]int, width, index, used, height int, cache [][]int) int {
	if index >= len(books) { return height }
	if cache[index][used] != -1 { return cache[index][used] }
	current := books[index]
	// new shelf
	answer := height + helper(books, width, index+1, current[0], current[1], cache)
	if current[0]+used <= width {
		answer = min(answer, helper(books, width, index+1, current[0]+used, max(height, current[1]), cache))
	}
	cache[index][used] = answer
	return answer
}