func findSpecialInteger(arr []int) int {
    count := 0
    current := -1
    for _, v := range arr {
        if v == current {
            count++
        } else {
            current = v
            count = 1
        }
        if 100*count > 25*len(arr) {
            return current
        }
    }
    return -1
}
