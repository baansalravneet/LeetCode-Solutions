func countCompleteDayPairs(hours []int) int64 {
    freq := make(map[int]int)
    var count int64 = 0
    for _, i := range hours {
        i %= 24
        if val, ok := freq[(24-i)%24]; ok {
            count += int64(val)
        }
        freq[i] += 1
    }
    return count
}
