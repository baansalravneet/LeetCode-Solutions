func minFallingPathSum(grid [][]int) int {
	n, min1, min2, min1Index := len(grid), 100, 100, -1
	for i := range grid {
		if grid[0][i] < min1 {
			min2, min1, min1Index = min1, grid[0][i], i
		} else if grid[0][i] < min2 {
			min2 = grid[0][i]
		}
	}
	for i := 1; i < n; i++ {
		m1, m2, m1i := math.MaxInt32, math.MaxInt32, -1
		for j := 0; j < n; j++ {
			next := grid[i][j]
			if j != min1Index {
				next += min1
			} else {
				next += min2
			}
			if next < m1 {
				m2, m1, m1i = m1, next, j
			} else if next < m2 {
				m2 = next
			}
		}
		min1, min2, min1Index = m1, m2, m1i
	}
	return min1
}