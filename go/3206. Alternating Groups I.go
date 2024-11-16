func numberOfAlternatingGroups(colors []int) int {
    count, n := 0, len(colors)
    for i := 0; i < n; i++ {
        if colors[i] != colors[(i-1+n)%n] &&
        colors[i] != colors[(i+1)%n] {
            count++
        }
    }
    return count
}
