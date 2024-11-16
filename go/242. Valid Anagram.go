func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    freqS := getFreq(s)
    freqT := getFreq(t)
    for i, v := range freqS {
        if v != freqT[i] {
            return false
        }
    }
    return true
}
func getFreq(s string) [26]int {
    answer := [26]int{}
    for _, char := range s {
        answer[char-'a']++
    }
    return answer
}
