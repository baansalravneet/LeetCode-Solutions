func isValid(s string) bool {
    stack := []byte{}
    for i := 0; i < len(s); i++ {
        if s[i] == '{' || s[i] == '(' || s[i] == '[' {
            stack = append(stack, s[i])
        } else {
            if s[i] == '}' {
                if len(stack) == 0 || stack[len(stack)-1] != '{' {
                    return false
                }
                stack = stack[:len(stack)-1]
            }
            if s[i] == ')' {
                if len(stack) == 0 || stack[len(stack)-1] != '(' {
                    return false
                }
                stack = stack[:len(stack)-1]
            }
            if s[i] == ']' {
                if len(stack) == 0 || stack[len(stack)-1] != '[' {
                    return false
                }
                stack = stack[:len(stack)-1]
            }
        }
    }
    return len(stack) == 0
}
