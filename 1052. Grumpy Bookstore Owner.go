func maxSatisfied(customers []int, grumpy []int, minutes int) int {
    answer := 0
    for i := range customers {
        if grumpy[i] == 0 {
            answer += customers[i]
        }
    }
    left, right := 0, 0
    maxAnswer := answer
    for right < minutes {
        if grumpy[right] == 1 {
            answer += customers[right]
            maxAnswer = max(maxAnswer, answer)
        }
        right++
    }
    for right < len(customers) {
        if grumpy[right] == 1 {
            answer += customers[right]
        }
        if grumpy[left] == 1 {
            answer -= customers[left]
        }
        right++
        left++
        maxAnswer = max(maxAnswer, answer)
    }
    return maxAnswer
}
