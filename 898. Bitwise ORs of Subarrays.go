func subarrayBitwiseORs(arr []int) int {
    result, current := make(map[int]bool), make(map[int]bool)
    for _, i := range arr {
        next := make(map[int]bool)
        next[i] = true
        for j := range current {
            next[j|i] = true
        }
        for j := range next {
            result[j] = true
        }
        current = next
    }
    return len(result)
}