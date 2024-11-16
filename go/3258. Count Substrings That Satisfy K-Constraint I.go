func countKConstraintSubstrings(s string, k int) int {
    answer := 0
    for i := 0; i < len(s); i++ {
        count := 0
        for j := i; j < len(s); j++ {
            if s[j] == '1' { count++ }
            if count <= k || j-i+1-count <= k { answer++ }
        }
    }
    return answer
}

