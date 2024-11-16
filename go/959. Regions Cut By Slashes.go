func regionsBySlashes(grid []string) int {
	n := len(grid)
	expanded := make([][]bool, 3*n)
	for i := range expanded {
		expanded[i] = make([]bool, 3*n)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '/' {
				expanded[3*i+2][3*j] = true
				expanded[3*i+1][3*j+1] = true
				expanded[3*i][3*j+2] = true
			} else if grid[i][j] == '\\' {
				expanded[3*i][3*j] = true
				expanded[3*i+1][3*j+1] = true
				expanded[3*i+2][3*j+2] = true
			}
		}
	}
	answer := 0
	for i := 0; i < len(expanded); i++ {
		for j := 0; j < len(expanded); j++ {
			if !expanded[i][j] {
				floodFill(&expanded, i, j)
				answer++
			}
		}
	}
	return answer
}

func floodFill(arr *[][]bool, i, j int) {
	if i < 0 || i >= len(*arr) || j < 0 || j >= len(*arr) {
		return;
	}
	if (*arr)[i][j] {
		return
	}
	(*arr)[i][j] = true
	floodFill(arr, i+1, j)
	floodFill(arr, i-1, j)
	floodFill(arr, i, j+1)
	floodFill(arr, i, j-1)
}