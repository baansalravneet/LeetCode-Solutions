func strangePrinter(s string) int {
    s = removeDuplicates(s)
    cache := make([][]int, len(s))
    for i := range cache {
        cache[i] = make([]int, len(s))
    }
    return helper(0, len(s)-1, s, cache)
}

func helper(start, end int, s string, cache [][]int) int {
    if start > end {
        return 0
    }
    if cache[start][end] > 0 {
        return cache[start][end]
    }
    answer := 1 + helper(start+1, end, s, cache)
    for i := start+1; i <= end; i++ {
        if s[i] == s[start] {
            answer = min(answer, helper(start, i-1, s, cache) + helper(i+1, end, s, cache))
        }
    }
    cache[start][end] = answer
    return answer
}

func removeDuplicates(s string) string {
    var sb strings.Builder
    for i := 0; i < len(s); {
        curr := s[i]
        sb.WriteByte(s[i])
        for i < len(s) && curr == s[i] {
            i++
        }
    }
    return sb.String()
}

