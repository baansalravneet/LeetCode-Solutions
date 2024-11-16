func numberOfRightTriangles(grid [][]int) int64 {
	colOnes := []int{}
	rowOnes := []int{}
	for i := range grid {
		count := 0
		for j := range grid[i] {
			count += grid[i][j]
		}
		rowOnes = append(rowOnes, count)
	}
	for j := range grid[0] {
		count := 0
		for i := range grid {
			count += grid[i][j]
		}
		colOnes = append(colOnes, count)
	}
	answer := 0
	for i := range grid {
		for j := range grid[i] {
			if colOnes[j] <= 1 || rowOnes[i] <= 1 || grid[i][j] == 0 {
				continue
			}
			answer += (colOnes[j] - 1) * (rowOnes[i] - 1)
		}
	}
	return int64(answer)
}