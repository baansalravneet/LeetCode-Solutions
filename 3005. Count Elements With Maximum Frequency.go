func maxFrequencyElements(nums []int) int {
    freq := [101]int{}
    maxFreq := 0
    for _, i := range(nums) {
        freq[i] += 1
        maxFreq = max(maxFreq, freq[i])
    }
    count := 0
    for _, i := range(nums) {
        if freq[i] == maxFreq {
            count++
        }
    }
    return count
}
