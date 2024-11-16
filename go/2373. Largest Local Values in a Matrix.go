func largestLocal(grid [][]int) [][]int {
	n := len(grid)
	answer := make([][]int, n-2)
	for i := range n - 2 {
		answer[i] = make([]int, n-2)
		for j := range n - 2 {
			answer[i][j] = grid[i][j]
			for x := range 3 {
				for y := range 3 {
					answer[i][j] = max(answer[i][j], grid[i+x][j+y])
				}
			}
		}
	}
	return answer
}