func countSubstrings(s string, c byte) int64 {
    var count int64
    for _, i := range(s) {
        if i == rune(c) {
            count++
        }
    }
    return (count * (count + 1))/2
}

