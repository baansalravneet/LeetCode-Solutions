func numberOfSubmatrices(grid [][]byte) int {
	n, m := len(grid), len(grid[0])
	xCount, yCount := make([][]int, n), make([][]int, n)
	for i := range xCount {
		xCount[i] = make([]int, m)
		yCount[i] = make([]int, m)
	}
	if grid[0][0] == 'X' {
		xCount[0][0] = 1
	}
	if grid[0][0] == 'Y' {
		yCount[0][0] = 1
	}
	answer := 0
	for i := 1; i < n; i++ {
		xCount[i][0] = xCount[i-1][0]
		if grid[i][0] == 'X' {
			xCount[i][0] += 1
		}
		yCount[i][0] = yCount[i-1][0]
		if grid[i][0] == 'Y' {
			yCount[i][0] += 1
		}
		if xCount[i][0] == yCount[i][0] && xCount[i][0] > 0 {
			answer++
		}
	}
	for j := 1; j < m; j++ {
		xCount[0][j] = xCount[0][j-1]
		if grid[0][j] == 'X' {
			xCount[0][j] += 1
		}
		yCount[0][j] = yCount[0][j-1]
		if grid[0][j] == 'Y' {
			yCount[0][j] += 1
		}
		if xCount[0][j] == yCount[0][j] && xCount[0][j] > 0 {
			answer++
		}
	}
	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			xCount[i][j] = xCount[i-1][j] + xCount[i][j-1] - xCount[i-1][j-1]
			if grid[i][j] == 'X' {
				xCount[i][j] += 1
			}
			yCount[i][j] = yCount[i-1][j] + yCount[i][j-1] - yCount[i-1][j-1]
			if grid[i][j] == 'Y' {
				yCount[i][j] += 1
			}
			if xCount[i][j] == yCount[i][j] && xCount[i][j] > 0 {
				answer++
			}
		}
	}
	return answer
}