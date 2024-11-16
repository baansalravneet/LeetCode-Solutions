func twoSum(nums []int, target int) []int {
    index := make(map[int]int)
    for idx, value := range nums {
        if saved, ok := index[target - value]; ok {
            return []int{saved, idx}
        }
        index[value] = idx
    }
    return []int{}
}
