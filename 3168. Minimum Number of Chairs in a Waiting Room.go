func minimumChairs(s string) int {
    count := 0
    answer := 0
    for _, i := range s {
        if i == 'E' {
            count += 1
        } else {
            count -= 1
        }
        answer = max(answer, count)
    }
    return answer
}
