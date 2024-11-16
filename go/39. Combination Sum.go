func combinationSum(candidates []int, target int) [][]int {
    result := [][]int{}
    current := []int{}
    var helper func(index, currentSum int)
    helper = func(index, currentSum int) {
        if index == len(candidates) || currentSum > target {
            return
        }
        if (currentSum == target) {
            result = append(result, append([]int{}, current...))
            return
        }
        helper(index+1, currentSum)
        current = append(current, candidates[index])
        helper(index, currentSum+candidates[index])
        current = current[:len(current)-1]
    }
    helper(0, 0)
    return result
}
