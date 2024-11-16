func countCompleteDayPairs(hours []int) int {
    count := 0
    for i := 0; i < len(hours); i++ {
        for j := i+1; j < len(hours); j++ {
            if (hours[i] + hours[j]) % 24 == 0 {
                count += 1
            }
        }
    }
    return count
}
