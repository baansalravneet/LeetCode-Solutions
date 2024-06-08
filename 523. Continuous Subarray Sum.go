func checkSubarraySum(nums []int, k int) bool {
    prefixMap := make(map[int]int)
    prefixMap[0] = -1
    current := 0
    for i := 0; i < len(nums); i++ {
        current += nums[i];
        current %= k
        if index, ok := prefixMap[(current + k) % k]; ok && i-index >= 2 {
            return true
        }
        if _, ok := prefixMap[current]; !ok {
            prefixMap[current] = i
        }
    }
    return false
}
