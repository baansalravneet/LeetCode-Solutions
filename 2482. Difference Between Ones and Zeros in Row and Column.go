func onesMinusZeros(grid [][]int) [][]int {
    onesRow := []int{}
    onesCol := []int{}
    zerosRow := []int{}
    zerosCol := []int{}
    n := len(grid)
    m := len(grid[0])
    for i := 0; i < n; i++ {
        count := 0
        for j := 0; j < m; j++ {
            count += grid[i][j]
        }
        onesRow = append(onesRow, count)
        zerosRow = append(zerosRow, n - count)
    }
    for j := 0; j < m; j++ {
        count := 0
        for i := 0; i < n; i++ {
            count += grid[i][j]
        }
        onesCol = append(onesCol, count)
        zerosCol = append(zerosCol, m - count)
    }
    diff := [][]int{}
    for i := 0; i < n; i++ {
        diff = append(diff, []int{})
        for j := 0; j < m; j++ {
            diff[i] = append(diff[i], onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j])
        }
    }
    return diff
}
