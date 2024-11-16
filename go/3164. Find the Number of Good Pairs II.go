func numberOfPairs(nums1 []int, nums2 []int, k int) int64 {
    var answer int64
    freq := make(map[int]int)
    for _, i := range nums2 {
        freq[i*k] += 1
    }
    for _, i := range nums1 {
        for _, factor := range getFactors(i) {
            answer += int64(freq[factor])
        }
    }
    return answer
}

func getFactors(num int) []int {
    answer := []int{}
    i := 1
    for ; i*i < num; i++ {
        if num%i == 0 {
            answer = append(answer, i)
            answer = append(answer, num/i)
        }
    }
    if i*i == num {
        answer = append(answer, i)
    }
    return answer
}
