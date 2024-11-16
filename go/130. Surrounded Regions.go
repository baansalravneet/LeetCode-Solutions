func solve(board [][]byte)  {
    for i := 0; i < len(board); i++ {
        if board[i][0] == 'O' {
            floodFill(&board, i, 0)
        }
        if board[i][len(board[0])-1] == 'O' {
            floodFill(&board, i, len(board[0])-1)
        }
    }
    for j := 0; j < len(board[0]); j++ {
        if board[0][j] == 'O' {
            floodFill(&board, 0, j)
        }
        if board[len(board)-1][j] == 'O' {
            floodFill(&board, len(board)-1, j)
        }
    }
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            if board[i][j] == 'O' {
                board[i][j] = 'X'
            } else if board[i][j] == 'A' {
                board[i][j] = 'O'
            }
        }
    }
}

func floodFill(board *[][]byte, i, j int) {
    if i < 0 || i >= len(*board) {
        return
    }
    if j < 0 || j >= len((*board)[0]) {
        return
    }
    if (*board)[i][j] != 'O' {
        return
    }
    (*board)[i][j] = 'A'
    floodFill(board, i+1, j)
    floodFill(board, i-1, j)
    floodFill(board, i, j+1)
    floodFill(board, i, j-1)
}
