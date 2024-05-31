func singleNumber(nums []int) []int {
    total := 0
    for _, i := range nums {
        total ^= i
    }
    set := 0
    for ; set < 32; set++ {
        if total & (1 << set) > 0 {
            break
        }
    }
    answer1 := 0
    answer2 := 0
    for _, i := range nums {
        if i & (1 << set) > 0 {
            answer1 ^= i
        } else {
            answer2 ^= i
        }
    }
    return []int{answer1, answer2}
}
