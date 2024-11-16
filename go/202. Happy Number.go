func isHappy(n int) bool {
    seenSoFar := make(map[int]bool)
    for n != 1 {
        if _, ok := seenSoFar[n]; ok {
            return false
        }
        seenSoFar[n] = true
        n = getNext(n)
    }
    return true
}

func getNext(n int) int {
    s := strconv.Itoa(n)
    next := 0
    for _, i := range s {
        next += int(i-'0') * int(i-'0')
    }
    return next
}
