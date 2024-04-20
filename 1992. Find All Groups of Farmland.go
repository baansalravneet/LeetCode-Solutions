func findFarmland(land [][]int) [][]int {
	result := [][]int{}
	var findEndpoints func(int, int) []int
	findEndpoints = func(row, col int) []int {
		i, j := row, col
		for i < len(land) && land[i][col] == 1 { i++ }
		for j < len(land[0]) && land[row][j] == 1 { j++ }
		for x := row; x < i; x++ {
			for y := col; y < j; y++ {
				land[x][y] = 0
			}
		}
		return []int{row, col, i - 1, j - 1}
	}

	for i := range land {
		for j := range land[0] {
			if land[i][j] == 1 {
				result = append(result, findEndpoints(i, j))
			}
		}
	}
	return result
}