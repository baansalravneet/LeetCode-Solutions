func wordPattern(pattern string, s string) bool {
    forwardMap := make(map[byte]string)
    reverseMap := make(map[string]byte)
    words := strings.Split(s, " ")
    if len(words) != len(pattern) {
        return false
    }
    for i := 0; i < len(pattern); i++ {
        char := pattern[i]
        word := words[i]

        mapWord, wordExists := forwardMap[char]
        if wordExists && mapWord != word {
            return false
        }

        mapChar, charExists := reverseMap[word]
        if charExists && mapChar != char {
            return false
        }

        forwardMap[char] = word
        reverseMap[word] = char
    }
    return true
}
