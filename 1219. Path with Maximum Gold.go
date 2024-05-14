func getMaximumGold(grid [][]int) int {
	answer := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			answer = max(answer, dfs(grid, i, j))
		}
	}
	return answer
}
func dfs(grid [][]int, currX, currY int) int {
	temp := grid[currX][currY]
	answer := 0
	grid[currX][currY] = 0
	for _, dir := range [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} {
		nextX, nextY := currX+dir[0], currY+dir[1]
		if nextX < 0 || nextX >= len(grid) {
			continue
		}
		if nextY < 0 || nextY >= len(grid[nextX]) {
			continue
		}
		if grid[nextX][nextY] == 0 {
			continue
		}
		answer = max(answer, dfs(grid, nextX, nextY))
	}
	grid[currX][currY] = temp
	return temp + answer
}
