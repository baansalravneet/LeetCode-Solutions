func maxDepth(s string) int {
    count, answer := 0, 0
    for _, c := range(s) {
        if c == '(' {
            count += 1
        } else if c == ')' {
            count -= 1
        }
        if answer < count {
            answer = count
        }
    }
    return answer
}
