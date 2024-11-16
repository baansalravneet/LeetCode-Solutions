func minDays(bloomDay []int, m int, k int) int {
    left, right, answer := 1000000000, 0, -1
    for _, i := range bloomDay {
        if left > i { left = i }
        if right < i { right = i }
    }
    for left <= right {
        mid := (left + right) / 2
        if canDo(bloomDay, mid, m, k) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return answer
}

func canDo(arr []int, val, m, k int) bool {
    count := 0
    for _, i := range arr {
        if i <= val {
            count += 1
        } else {
            count = 0
        }
        if count == k {
            count = 0
            m -= 1
        }
    }
    return m <= 0
}
