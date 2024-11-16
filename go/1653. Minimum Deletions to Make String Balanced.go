func minimumDeletions(s string) int {
    n := len(s)
    a, b := 0, 0
    if s[0] == 'a' {
        b = 1
    } else {
        a = 1
    }
    for i := 1; i < n; i++ {
        if s[i] == 'a' {
			b = min(a, b+1)
        } else {
			b = min(a, b)
			a++
        }
    }
    return min(a, b)
}