func numIslands(grid [][]byte) int {
    count := 0
    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if (grid[i][j] == '1') {
                count++;
                floodFill(&grid, i, j)
            }
        }
    }
    return count
}

func floodFill(grid *[][]byte, i, j int) {
    if i < 0 || i >= len(*grid) {
        return
    }
    if j < 0 || j >= len((*grid)[0]) {
        return
    }
    if (*grid)[i][j] == '0' {
        return
    }
    (*grid)[i][j] = '0'
    floodFill(grid, i+1, j)
    floodFill(grid, i-1, j)
    floodFill(grid, i, j+1)
    floodFill(grid, i, j-1)

}
