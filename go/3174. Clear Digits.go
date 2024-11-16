func clearDigits(s string) string {
    answer := ""
    for _, c := range s {
        if c >= '0' && c <= '9' {
            answer = answer[:len(answer)-1]
        } else {
            answer += string(c)
        }
    }
    return answer
}
