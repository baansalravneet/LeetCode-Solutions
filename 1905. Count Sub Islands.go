func countSubIslands(grid1 [][]int, grid2 [][]int) int {
    n, m := len(grid2), len(grid2[0])
    answer := 0
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if grid2[i][j] == 1 {
                if floodFill(grid2, grid1, i, j, n, m, true) {
                    answer++
                }
            }
        }
    }
    return answer
}

func floodFill(grid2, grid1 [][]int, x, y, n, m int, answer bool) bool {
    if x >= n || x < 0 || y >= m || y < 0 { return answer }
    if grid2[x][y] == 0 { return answer }
    grid2[x][y] = 0
    if grid1[x][y] == 0 { answer = false }
    answer = floodFill(grid2, grid1, x+1, y, n, m, answer)
    answer = floodFill(grid2, grid1, x-1, y, n, m, answer)
    answer = floodFill(grid2, grid1, x, y+1, n, m, answer)
    answer = floodFill(grid2, grid1, x, y-1, n, m, answer)
    return answer
}
