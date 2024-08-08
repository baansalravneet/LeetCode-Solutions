func spiralMatrixIII(rows int, cols int, rStart int, cStart int) [][]int {
    d := [][] int {
        []int { 0, 1 },
        []int { 1, 0 },
        []int { 0, -1 },
        []int { -1, 0 },
    }
    answer := [][]int{
        []int { rStart, cStart },
    }
    if rows * cols == 1 { return answer }
    length, dir := 1, 0
    pos := []int {rStart, cStart}
    LOOP: for {
        for i := 0; i < length; i++ {
            pos[0] += d[dir][0]
            pos[1] += d[dir][1]
            if pos[0] >= 0 && pos[0] < rows && pos[1] >= 0 && pos[1] < cols {
                answer = append(answer, []int {pos[0], pos[1]})
                if len(answer) == rows * cols { break LOOP }
            }
        }
        dir = (dir+1) % 4
        if dir == 2 || dir == 0 {
            length++
        }
    }
    return answer
}
