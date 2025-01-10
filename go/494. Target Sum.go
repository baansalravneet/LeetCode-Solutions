func findTargetSumWays(nums []int, target int) int {
    sum := 0
    for _, v := range nums {
        sum += v
    }
    cache := make([][]int, len(nums))
    for i := range cache {
        cache[i] = make([]int, 2*sum + 1)
        for j := range cache[i] {
            cache[i][j] = -1
        }
    }
    return helper(nums, target, sum, 0, 0, cache)
}

func helper(nums []int, target, sum, currentSum, index int, cache [][]int) int {
    if index == len(nums) {
        if target == currentSum {
            return 1
        }
        return 0
    }
    if cache[index][currentSum+sum] != -1 {
        return cache[index][currentSum+sum]
    }
    answer := helper(nums, target, sum, currentSum+nums[index], index+1, cache)
    answer += helper(nums, target, sum, currentSum-nums[index], index+1, cache)
    cache[index][currentSum+sum] = answer
    return answer
}
