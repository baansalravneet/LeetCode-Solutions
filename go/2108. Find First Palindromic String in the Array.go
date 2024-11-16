func firstPalindrome(words []string) string {
    for _, s := range(words) {
        if palindrome(s) {
            return s
        }
    }
    return ""
}

func palindrome(s string) bool {
    for i := 0; i < len(s)/2; i++ {
        if s[i] != s[len(s)-i-1] {
            return false
        }
    }
    return true
}
