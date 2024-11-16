func canConstruct(ransomNote string, magazine string) bool {
    noteFreq := getFreq(ransomNote)
    magFreq := getFreq(magazine)
    for i := 0; i < 26; i++ {
        if noteFreq[i] > magFreq[i] {
            return false
        }
    }
    return true
}

func getFreq(s string) [26]int {
    count := [26]int{}
    for i := 0; i < len(s); i++ {
        char := s[i]
        count[char - 'a']++
    }
    return count
}
