func maximizeTheProfit(n int, offers [][]int) int {
	sort.Slice(offers, func(i, j int) bool { return offers[i][0] < offers[j][0] })
	cache := make([]int, len(offers))
	for i := range cache {
		cache[i] = -1
	}
	return helper(offers, 0, cache)
}
func helper(offers [][]int, i int, cache []int) int {
	if i == len(offers) {
		return 0
	}
	if cache[i] != -1 {
		return cache[i]
	}
	answer1 := helper(offers, i+1, cache)
	answer2 := offers[i][2]
	next := findNext(offers, i, offers[i][1])
	answer2 += helper(offers, next, cache)
	cache[i] = max(answer1, answer2)
	return cache[i]
}
func findNext(offers [][]int, i, end int) int {
	left, right, answer := i+1, len(offers)-1, len(offers)
	for left <= right {
		mid := (left + right) / 2
		if offers[mid][0] > end {
			answer = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return answer
}