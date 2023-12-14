func minWindow(s string, t string) string {
    tCount := make(map[rune]int)
    for _, char := range t {
        tCount[char] += 1
    }
    left := 0
    matched := 0
    answerStart := -1
    answerLength := math.MaxInt32
    for right, char := range s {
        if _, ok := tCount[char]; ok {
            tCount[char]--
            if tCount[char] == 0 {
                matched++
            }
        }
        for matched == len(tCount) {
            if right - left + 1 < answerLength {
                answerStart = left
                answerLength = right-left+1
            }
            if _, ok := tCount[rune(s[left])]; ok {
                if tCount[rune(s[left])] == 0 {
                    matched--
                }
                tCount[rune(s[left])]++
            }
            left++
        }
    }
    if answerStart == -1 {
        return ""
    }
    return s[answerStart:answerStart+answerLength]
}
