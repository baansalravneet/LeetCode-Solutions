func isSubstringPresent(s string) bool {
    n := len(s)
    for i := 1; i < n; i++ {
        a := string(s[i]) + string(s[i-1])
        if strings.Contains(s, a) {
            return true
        }
    }
    return false
}

