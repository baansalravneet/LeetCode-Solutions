func longestCommonPrefix(strs []string) string {
    return helper(strs, 0, len(strs) - 1)
}
func helper(strs []string, left, right int) string {
    if left == right {
        return strs[left]
    }
    mid := (left+right)/2
    leftString := helper(strs, left, mid)
    rightString := helper(strs, mid+1, right)
    i := 0
    for i < len(leftString) && i < len(rightString) {
        if leftString[i] == rightString[i] {
            i++
        } else {
            break
        }
    }
    return strs[left][0:i]
}
