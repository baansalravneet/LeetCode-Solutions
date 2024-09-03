func getLucky(s string, k int) int {
    answer := 0
    for _, v := range s {
        answer += getDigitSum(int(v-'a'+1))
    }
    for k > 1 {
        answer = getDigitSum(answer)
        k--
    }
    return answer
}

func getDigitSum(i int) int {
    answer := 0
    for i > 0 {
        answer += i % 10
        i /= 10
    }
    return answer
}

