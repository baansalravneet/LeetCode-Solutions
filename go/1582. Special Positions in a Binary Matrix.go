func numSpecial(mat [][]int) int {
    count := 0
    rowMap := make(map[int]bool)
    for i := 0; i < len(mat); i++ {
        localCount := 0
        for j := 0; j < len(mat[0]); j++ {
            localCount += mat[i][j]
        }
        if localCount == 1 {
            rowMap[i] = true
        }
    }
    
    for j := 0; j < len(mat[0]); j++ {
        localCount := 0
        index := -1
        for i := 0; i < len(mat); i++ {
            localCount += mat[i][j]
            if mat[i][j] == 1 {
                index = i
            }
        }
        if _, ok := rowMap[index]; ok && localCount == 1 {
            count++
        }
    }
    return count
     
}
