func getSmallestString(s string) string {
    arr := []rune(s)
    for i := 0; i < len(s)-1; i++ {
        num1, num2 := int(arr[i]-'0'), int(arr[i+1]-'0')
        if (num1%2==0) != (num2%2==0) { continue }
        if num1 > num2 {
            arr[i], arr[i+1] = arr[i+1], arr[i]
            break
        }
    }
    return string(arr)
}