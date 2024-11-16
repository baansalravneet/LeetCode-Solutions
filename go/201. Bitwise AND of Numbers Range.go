func rangeBitwiseAnd(left int, right int) int {
    diff := right - left
    answer := right & left
    for i := 0; i < 32; i++ {
        if diff < powInt(2, i) {
            break
        } else {
            answer &= ^(1 << i)
        }
    }
    return answer
}

func powInt(x, y int) int {
    return int(math.Pow(float64(x), float64(y)))
}

