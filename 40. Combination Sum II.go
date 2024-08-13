func combinationSum2(arr []int, target int) [][]int {
    var helper func(int, int, *[]int)
    answer := [][]int{}
    helper = func(index, sum int, current *[]int) {
        if index == len(arr) {
            if sum == target {
                result := make([]int, len(*current))
                copy(result, *current)
                answer = append(answer, result)
            }
            return
        }
        if sum > target { return }
        *current = append(*current, arr[index])
        helper(index+1, sum+arr[index], current)
        *current = (*current)[:len(*current)-1]
        i := index+1
        for i < len(arr) && arr[i] == arr[index] {
            i++
        }
        helper(i, sum, current)
    }
    sort.Ints(arr)
    helper(0, 0, &[]int{})
    return answer
}
