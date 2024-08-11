func minDays(grid [][]int) int {
	n, m := len(grid), len(grid[0])
	if findComponents(grid, n, m) != 1 {
		return 0
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if grid[i][j] == 0 {
				continue
			}
			grid[i][j] = 0
			if findComponents(grid, n, m) != 1 {
				return 1
			}
			grid[i][j] = 1
		}
	}
	return 2
}

func findComponents(grid [][]int, n, m int) int {
	answer := 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if grid[i][j] == 0 || grid[i][j] == 2 {
				continue
			}
			floodFill(grid, n, m, i, j)
			answer++
		}
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if grid[i][j] == 2 {
				grid[i][j] = 1
			}
		}
	}
	return answer
}

func floodFill(grid [][]int, n, m, i, j int) {
	if i < 0 || i >= n || j < 0 || j >= m {
		return
	}
	if grid[i][j] == 0 || grid[i][j] == 2 {
		return
	}
	grid[i][j] = 2
	floodFill(grid, n, m, i-1, j)
	floodFill(grid, n, m, i+1, j)
	floodFill(grid, n, m, i, j+1)
	floodFill(grid, n, m, i, j-1)
}