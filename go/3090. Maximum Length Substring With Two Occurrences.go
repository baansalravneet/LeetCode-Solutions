func maximumLengthSubstring(s string) int {
    answer := 0
    for i, _ := range(s) {
        answer = max(find(s, i), answer)
    }
    return answer
}
func find(s string, start int) int {
    freq := [26]int{}
    length := 0
    for i := start; i < len(s); i++ {
        if freq[s[i]-'a'] == 2 {
            return length
        }
        freq[s[i]-'a'] += 1
        length += 1
    }
    return length
}

