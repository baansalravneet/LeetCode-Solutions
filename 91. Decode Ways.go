func numDecodings(s string) int {
    if s[0] == '0' {
        return 0
    }
    dp := make([]int, len(s))
    dp[0] = 1
    for i := 1; i < len(s); i++ {
        if s[i] != '0' {
            dp[i] += dp[i-1]
        }
        val := (s[i-1]-'0')*10 + s[i]-'0' 
        if val > 9 && val < 27 {
            if i == 1 {
                dp[i] += 1
            } else {
                dp[i] += dp[i-2]
            }
        }
    }
    return dp[len(s)-1]
}

func numDecodings(s string) int {
    var helper func(s string, i int, cache map[int]int) int
    helper = func(s string, i int, cache map[int]int) int {
        if i >= len(s) {
            return 1
        }
        if s[i] == '0' {
            return 0
        }
        if v, ok := cache[i]; ok {
            return v
        }
        answer := 0
        if s[i] != '0' {
            answer += helper(s, i+1, cache)
        }
        if i < len(s) - 1 {
            val := (s[i]-'0')*10+s[i+1]-'0' 
            if val > 9 && val < 27 {
                answer += helper(s, i+2, cache)
            }
        }
        cache[i] = answer
        return answer
    }
    cache := make(map[int]int)
    return helper(s, 0, cache)
}
