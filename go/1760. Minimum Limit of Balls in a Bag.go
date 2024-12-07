func minimumSize(nums []int, maxOperations int) int {
    left, right := 1, -1
    for _, i := range nums {
        right = max(right, i)
    }
    answer := -1
    for left <= right {
        mid := (left + right) / 2
        if isPossible(nums, mid, maxOperations) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return answer
}
func isPossible(nums []int, maxNum, maxOp int) bool {
    count := 0
    for _, i := range nums {
        if i <= maxNum {
            continue
        }
        count += i/maxNum
        if i % maxNum == 0 {
            count--
        }
    }
    return count <= maxOp
}
