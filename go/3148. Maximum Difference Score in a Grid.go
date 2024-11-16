func maxScore(grid [][]int) int {
	n := len(grid)
	m := len(grid[0])
	mins := make([][]int, n)
	for i := range mins {
		mins[i] = make([]int, m)
	}
	mins[0][0] = grid[0][0]
	answer := math.MinInt32
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if i == 0 && j == 0 {
				continue
			}
			if j == 0 {
				answer = max(answer, grid[i][0]-mins[i-1][0])
				mins[i][0] = min(mins[i-1][0], grid[i][0])
			} else if i == 0 {
				answer = max(answer, grid[0][j]-mins[0][j-1])
				mins[0][j] = min(mins[0][j-1], grid[0][j])
			} else {
				answer = max(answer, grid[i][j]-mins[i-1][j], grid[i][j]-mins[i][j-1])
				mins[i][j] = min(mins[i-1][j], mins[i][j-1], grid[i][j])
			}
		}
	}
	return answer
}