func isSubsequence(s string, t string) bool {
    idxS := 0
    idxT := 0
    for idxT < len(t) && idxS < len(s) {
        if s[idxS] == t[idxT] {
            idxS++
            idxT++
        } else {
            idxT++
        }
    }
    return idxS == len(s)
}
