func canMakeSquare(grid [][]byte) bool {
	directions := [][]int{{0, 0}, {0, 1}, {1, 0}, {1, 1}}
	for _, d := range directions {
		i, j := d[0], d[1]
		count := 0
		for _, d1 := range directions {
			x, y := d1[0], d1[1]
			if grid[i+x][j+y] == 'B' {
				count += 1
			}
		}
		if count != 2 {
			return true
		}
	}
	return false
}