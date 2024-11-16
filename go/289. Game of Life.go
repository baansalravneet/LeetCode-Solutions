func gameOfLife(board [][]int)  {
    directions := [][]int {
        {1,0}, {1,1}, {1,-1}, {-1,1},
        {-1,0}, {-1,-1}, {0,1}, {0,-1},
    }
    findAlive := func(i, j int) int {
        count := 0
        for _, d := range directions {
            x, y := i+d[0], j+d[1]
            if x < 0 || x >= len(board) { continue }
            if y < 0 || y >= len(board[0]) { continue }
            if board[x][y] == 1 || board[x][y] == 3 { count++ }
        }
        return count
    }
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            count := findAlive(i, j)
            if board[i][j] == 1 {
                if count < 2 || count > 3 {
                    board[i][j] = 3
                }
            } else {
                if count == 3 {
                    board[i][j] = 2
                }
            }
        }
    }
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            if board[i][j] == 2 {
                board[i][j] = 1
            } else if board[i][j] == 3 {
                board[i][j] = 0
            }
        }
    }
}