func spiralOrder(matrix [][]int) []int {
    var answer []int
    top := -1
    left := -1
    right := len(matrix[0])
    bottom := len(matrix)
    direction := 0
    count := right * bottom
    x, y := 0, 0
    for count > 0 {
        count--
        answer = append(answer, matrix[x][y])
        if direction == 0 {
            y++
            if y == right {
                y--
                x++
                top++
                direction = 1
            }
        } else if direction == 1 {
            x++
            if x == bottom {
                x--
                y--
                right--
                direction = 2
            }
        } else if direction == 2 {
            y--
            if y == left {
                y++
                x--
                bottom--
                direction = 3
            }
        } else {
            x--
            if x == top {
                x++
                y++
                left++
                direction = 0
            }
        }
    }
    return answer
}
