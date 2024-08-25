func countPairs(nums []int) int {
    sort.Ints(nums)
    freq := make(map[int]int)
    answer := 0
    for _, num := range nums {
        swap := getSwaps(num)
        total := make(map[int]bool)
        for j := range swap {
            for k := range getSwaps(j) {
                total[k] = true
            }
        }
        for i := range total {
            answer += freq[i]
        }
        freq[num]++
    }
    return answer
}

func getSwaps(num int) map[int]bool {
    result := make(map[int]bool)
    result[num] = true
    digits := getDigits(num)
    for i := 0; i < len(digits); i++ {
        for j := i+1; j < len(digits); j++ {
            digits[i], digits[j] = digits[j], digits[i]
            result[getVal(digits)] = true
            digits[i], digits[j] = digits[j], digits[i]
        }
    }
    return result
}

func getDigits(num int) []int {
    answer := []int{}
    for num > 0 {
        answer = append(answer, num % 10)
        num /= 10
    }
    return answer
}

func getVal(digits []int) int {
    answer := 0;
    for i := len(digits)-1; i >= 0; i-- {
        answer *= 10
        answer += digits[i]
    }
    return answer
}

