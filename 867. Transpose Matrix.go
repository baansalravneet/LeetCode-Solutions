func transpose(matrix [][]int) [][]int {
    answer := make([][]int, len(matrix[0]))
    for i := range answer {
        answer[i] = make([]int, len(matrix))
    }

    for i, row := range matrix {
        for j, v := range row {
            answer[j][i] = v
        }
    }
    return answer
}
