func findTheWinner(n int, k int) int {
    out := make([]bool, n)
    current := 0
    remaining := n
    for {
        if remaining == 1 { break }
        count := 1
        for count < k {
            current++
            current %= n
            if out[current] { continue }
            count++
        }
        out[current] = true
        remaining--
        for {
            current++
            current %= n
            if !out[current] { break }
        }
    }
    return current+1
}