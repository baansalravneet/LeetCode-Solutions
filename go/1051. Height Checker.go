func heightChecker(heights []int) int {
    copy := append([]int{}, heights...)
    sort.Ints(copy)
    answer := 0
    for i := 0; i < len(heights); i++ {
        if heights[i] != copy[i] {
            answer += 1
        }
    }
    return answer
}
