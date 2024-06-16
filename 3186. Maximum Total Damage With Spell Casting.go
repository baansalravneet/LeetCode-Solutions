func maximumTotalDamage(power []int) int64 {
    sort.Ints(power)
    freq := make(map[int]int)
    for _, i := range power {
        freq[i] += 1
    }
    cache := make([]int64, len(power))
    for i := range cache {
        cache[i] = -1
    }
    return find(power, 0, freq, cache)
}
func find(power []int, index int, freq map[int]int, cache []int64) int64 {
    if index >= len(power) { return 0 }
    if cache[index] != -1 { return cache[index] }
    answer1 := find(power, index + freq[power[index]], freq, cache)
    answer2 := int64(power[index] * freq[power[index]])
    i := index + freq[power[index]] + freq[power[index]+1] + freq[power[index]+2]
    answer2 += find(power, i, freq, cache)
    cache[index] = max(answer1, answer2)
    return cache[index]
}
