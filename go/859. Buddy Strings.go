func buddyStrings(s string, goal string) bool {
    if len(s) != len(goal) {
        return false
    }
    freq1 := [26]int{}
    freq2 := [26]int{}
    diffCount := 0
    flag := 0
    for i := 0; i < len(s); i++ {
        freq1[s[i]-'a'] += 1
        freq2[goal[i]-'a'] += 1
        if s[i] != goal[i] {
            diffCount += 1
        }
    }
    for i := 0; i < 26; i++ {
        if freq1[i] > 1 {
            flag += 1
        }
        if freq1[i] != freq2[i] {
            return false
        }
    }
    return diffCount == 2 || (diffCount == 0 && flag > 0)
}




