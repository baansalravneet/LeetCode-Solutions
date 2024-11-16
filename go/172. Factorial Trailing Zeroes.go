func trailingZeroes(n int) int {
    count := 0
    for i := 5; i <= n; i++ {
        count += getFives(i)
    }
    return count
}
func getFives(i int) int {
    count := 0
    for i > 1 {
        if i % 5 == 0 {
            count++
            i /= 5
        } else {
            return count
        }
    }
    return count
}
