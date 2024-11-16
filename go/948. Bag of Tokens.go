func bagOfTokensScore(tokens []int, power int) int {
    slices.Sort(tokens)
    left, right, answer, score := 0, len(tokens)-1, 0, 0
    for left <= right {
        if power >= tokens[left] {
            power -= tokens[left]
            left++
            score++
            answer = max(answer, score)
        } else {
            if score == 0 {
                return 0
            }
            power += tokens[right]
            right--
            score--
        }
    }
    return answer
}


