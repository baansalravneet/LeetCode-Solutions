func appendCharacters(s string, t string) int {
    tIndex, sIndex := 0, 0
    for tIndex < len(t) && sIndex < len(s) {
        if t[tIndex] == s[sIndex] {
            tIndex++
            sIndex++
        } else {
            sIndex++
        }
    }
    return len(t) - tIndex
}
