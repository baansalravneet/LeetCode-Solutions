func subarraysDivByK(nums []int, k int) int {
    freq := make(map[int]int)
    freq[0] = 1
    answer, current := 0, 0
    for _, i := range nums {
        current += i
        for current < 0 {
            current += k
        }
        current %= k
        answer += freq[current]
        freq[current] += 1
    }
    return answer
}
