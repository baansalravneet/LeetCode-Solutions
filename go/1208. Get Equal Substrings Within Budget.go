func equalSubstring(s string, t string, maxCost int) int {
    left, current, answer := 0, 0, 0
    for right := 0; right < len(s); right++ {
        current += abs(int(s[right]) - int(t[right]))
        for left <= right && current > maxCost {
            current -= abs(int(s[left]) - int(t[left]))
            left++
        }
        answer = max(answer, right - left + 1)
    }
    return answer
}

func abs(i int) int {
    if i < 0 {
        return -i
    }
    return i
}
