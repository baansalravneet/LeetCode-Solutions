func evalRPN(tokens []string) int {
    stack := []int{}
    for _, token := range tokens {
        if token == "+" {
            op1 := stack[0]
            op2 := stack[1]
            stack = append([]int{op1+op2}, stack[2:]...)
        } else if token == "-" {
            op2 := stack[0]
            op1 := stack[1]
            stack = append([]int{op1-op2}, stack[2:]...)
        } else if token == "/" {
            op2 := stack[0]
            op1 := stack[1]
            stack = append([]int{op1/op2}, stack[2:]...)
        } else if token == "*" {
            op1 := stack[0]
            op2 := stack[1]
            stack = append([]int{op1*op2}, stack[2:]...)
        } else {
            value, _ := strconv.Atoi(token)
            stack = append([]int{value}, stack...)
        }
    }
    return stack[0]
}
