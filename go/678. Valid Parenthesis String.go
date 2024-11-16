func checkValidString(s string) bool {
    openCount, closeCount, length := 0, 0, len(s)
    for i := range(length) {
        if s[i] == '(' || s[i] == '*' {
            openCount += 1
        } else {
            openCount -= 1
        }
        if s[length-1-i] == ')' || s[length-1-i] == '*' {
            closeCount += 1
        } else {
            closeCount -= 1
        }
        if openCount < 0 || closeCount < 0 {
            return false
        }
    }
    return true
}
