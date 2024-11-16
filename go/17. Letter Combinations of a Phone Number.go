func letterCombinations(digits string) []string {
    numpad := map[byte]string {
        '2': "abc",
        '3': "def",
        '4': "ghi",
        '5': "jkl",
        '6': "mno",
        '7': "pqrs",
        '8': "tuv",
        '9': "wxyz",
    }
    result := []string{}
    if digits == "" {
        return result
    }
    current := []byte{}
    var backtrack func(index int)
    backtrack = func(index int) {
        if index == len(digits) {
            result = append(result, string(current))
            return
        }
        digit := digits[index]
        for _, n := range numpad[digit] {
            current = append(current, byte(n))
            backtrack(index+1)
            current = current[:len(current)-1]
        }
    }
    backtrack(0)
    return result
}
