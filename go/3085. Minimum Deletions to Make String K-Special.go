func minimumDeletions(word string, k int) int {
    freq := [26]int{}
    for _, i := range(word) {
        freq[i-'a'] += 1
    }
    f := []int{}
    for _, i := range(freq) {
        if i != 0 {
            f = append(f, i)
        }
    }
    slices.Sort(f)
    return find(f, 0, len(f)-1, k)
}

func find(f []int, left, right, k int) int {
    if left >= right {
        return 0
    }
    if f[right] - f[left] <= k {
        return 0
    }
    return min(f[left] + find(f, left+1, right, k), f[right] - f[left] - k + find(f, left, right-1, k))
}
