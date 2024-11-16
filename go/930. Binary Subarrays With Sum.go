func numSubarraysWithSum(nums []int, goal int) int {
    prefixCount := map[int]int{}
    sum, count := 0, 0
    prefixCount[0] = 1
    for _, i := range(nums) {
        sum += i
        count += prefixCount[sum - goal]
        prefixCount[sum] += 1
    }
    return count
}

