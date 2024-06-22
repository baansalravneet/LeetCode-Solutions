func numberOfSubarrays(nums []int, k int) int {
    n := len(nums)
    freq := make(map[int]int)
    freq[0] = 1
    count := 0
    answer := 0
    for i := 0; i < n; i++ {
        if nums[i] % 2 != 0 {
            count += 1
        }
        answer += freq[count-k]
        freq[count] += 1
    }
    return answer
}
