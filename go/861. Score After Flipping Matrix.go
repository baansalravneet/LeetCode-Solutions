func matrixScore(grid [][]int) int {
	n := len(grid)
	m := len(grid[0])
	rowFlips := make([]int, n)
	colFlips := make([]int, m)
	for i := 0; i < n; i++ {
		if grid[i][0] == 0 {
			rowFlips[i]++
		}
	}
	for j := 1; j < m; j++ {
		count := 0
		for i := 0; i < n; i++ {
			if (grid[i][j]+rowFlips[i])%2 != 0 {
				count++
			}
		}
		if count <= n/2 {
			colFlips[j]++
		}
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			grid[i][j] = (grid[i][j] + rowFlips[i] + colFlips[j]) % 2
		}
	}
	answer := 0
	for i := 0; i < n; i++ {
		answer += getScore(grid[i])
	}
	return answer
}
func getScore(arr []int) int {
	answer := 0
	current := 1
	for i := len(arr) - 1; i >= 0; i-- {
		answer += arr[i] * current
		current *= 2
	}
	return answer
}