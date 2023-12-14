func longestConsecutive(nums []int) int {
    set := make(map[int]bool)
    for _, i := range nums {
        set[i] = true
    }
    count := 0
    for _, i := range nums {
        // do not count if you have a smaller number
        if _, ok := set[i-1]; ok {
            continue
        }
        // start counting with this number
        current := 0
        c := i
        for {
            if _, ok := set[c]; !ok {
                break
            }
            c++
            current++
        }
        count = max(count, current)
        if current > len(nums)/2 {
            return count
        }
    }
    return count
}
