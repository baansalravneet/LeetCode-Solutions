package test
func exist(board [][]byte, word string) bool {
    visited := make([][]bool, len(board))
    for i := 0; i < len(board); i++ {
        visited[i] = make([]bool, len(board[0]))
    }
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            if (search(board, word, i, j, 0, &visited)) {
                return true
            }
        }
    }
    return false
}

func search(board[][] byte, word string, i, j, index int, visited *[][]bool) bool {
    if index == len(word) {
        return true
    }
    if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) || board[i][j] != word[index] || (*visited)[i][j] {
        return false
    }
    (*visited)[i][j] = true
    if search(board, word, i+1, j, index+1, visited) || search(board, word, i, j+1, index+1, visited) || search(board, word, i, j-1, index+1, visited) || search(board, word, i-1, j, index+1, visited) {
        return true;
    }
    (*visited)[i][j] = false
    return false
            
}
