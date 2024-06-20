func maxDistance(position []int, m int) int {
    left, right, answer := 1, 1000000000, -1
    sort.Ints(position)
    for left <= right {
        mid := (left + right) / 2
        if canPlace(position, mid, m-1) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return answer
}

func canPlace(position []int, minDistance, m int) bool {
    previousPosition := position[0]
    for i := 1; i < len(position); i++ {
        if position[i] - previousPosition >= minDistance {
            previousPosition = position[i]
            m--
        }
    }
    return m <= 0
}
