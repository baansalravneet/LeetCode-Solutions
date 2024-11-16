func islandPerimeter(grid [][]int) int {
    n, m, count := len(grid), len(grid[0]), 0
    for i := range(grid) {
        for j := range(grid[i]) {
            if grid[i][j] == 1 {
                if i == 0 { count += 1 }
                if j == 0 { count += 1 }
                if i == n-1 { count += 1 }
                if j == m-1 { count += 1 }
                if i > 0 && grid[i-1][j] == 0 { count += 1 }
                if j > 0 && grid[i][j-1] == 0 { count += 1 }
                if i < n-1 && grid[i+1][j] == 0 { count += 1 }
                if j < m-1 && grid[i][j+1] == 0 { count += 1 }
            }
        }
    }
    return count
}
