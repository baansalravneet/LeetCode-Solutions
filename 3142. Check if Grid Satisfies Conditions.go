func satisfiesConditions(grid [][]int) bool {
	for j := 0; j < len(grid[0]); j++ {
		if j != 0 && grid[0][j] == grid[0][j-1] {
			return false
		}
		for i := 0; i < len(grid); i++ {
			if i != 0 && grid[i][j] != grid[i-1][j] {
				return false
			}
		}
	}
	return true
}