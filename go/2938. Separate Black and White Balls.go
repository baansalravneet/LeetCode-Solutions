func minimumSteps(s string) int64 {
    var answer int64
    index := 0
    for i, c := range s {
        if c == '0' {
            answer += int64(i - index)
            index++
        }
    }
    return answer
}
