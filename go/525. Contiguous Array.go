func findMaxLength(nums []int) int {
    n := len(nums)
    sum := 0
    prefixMap := make(map[int]int)
    prefixMap[0] = -1
    answer := 0
    for i := 0; i < n; i++ {
        if nums[i] == 1 {
            sum += 1
        } else {
            sum -= 1
        }
        if x, ok := prefixMap[sum]; ok {
            if i-x > answer {
                answer = i-x
            }
        } else {
            prefixMap[sum] = i
        }
    }
    return answer
}
