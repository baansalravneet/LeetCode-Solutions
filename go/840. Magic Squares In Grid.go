func numMagicSquaresInside(grid [][]int) int {
	if len(grid) < 3 || len(grid[0]) < 3 { return 0 }
	answer := 0
	for i := 0; i < len(grid)-2; i++ {
		for j := 0; j < len(grid[0])-2; j++ {
			if check(grid, i, j) { answer++ }
		}
	}
	return answer
}

func check(grid [][]int, i, j int) bool {
	seen := make([]bool, 10)
	for x := i; x < i+3; x++ {
		for y := j; y < j+3; y++ {
			if grid[x][y] > 9 || grid[x][y] < 1 { return false }
			if seen[grid[x][y]] { return false }
			seen[grid[x][y]] = true
		}
	}
	sum := grid[i][j] + grid[i+1][j] + grid[i+2][j]
	if sum != grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] { return false }
	if sum != grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] { return false }
	if sum != grid[i][j] + grid[i][j+1] + grid[i][j+2] { return false }
	if sum != grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] { return false }
	if sum != grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] { return false }
	if sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] { return false }
	if sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2] { return false }
	return true
}