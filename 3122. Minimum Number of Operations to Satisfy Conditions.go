func minimumOperations(grid [][]int) int {
	n, m := len(grid), len(grid[0])
	cost := make([][]int, m)
	for j := range cost {
		cost[j] = make([]int, 10)
		freq := make([]int, 10)
		for i := range n {
			freq[grid[i][j]] += 1
		}
		for i := range 10 {
			cost[j][i] = n - freq[i]
		}
	}
	cache := make(map[[2]int]int)
	return helper(cost, 0, -1, cache)
}
func helper(cost [][]int, current, previous int, cache map[[2]int]int) int {
	if current == len(cost) {
		return 0
	}
	if val, ok := cache[[2]int{current, previous}]; ok {
		return val
	}
	answer := math.MaxInt32
	for i := range 10 {
		if i == previous {
			continue
		}
		answer = min(answer, cost[current][i]+helper(cost, current+1, i, cache))
	}
	cache[[2]int{current, previous}] = answer
	return answer
}