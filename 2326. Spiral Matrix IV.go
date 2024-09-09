/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func spiralMatrix(m int, n int, head *ListNode) [][]int {
    result := make([][]int, m)
    for i := range result {
        result[i] = make([]int, n)
        for j := range result[i] {
            result[i][j] = -1
        }
    }
    top, left, right, bottom, dir := -1, -1, n, m, 0
    x, y := 0, 0
    for head != nil {
        result[x][y] = head.Val
        head = head.Next
        if dir == 0 {
            y++
            if y == right {
                x, y, dir, top = x+1, y-1, 1, top+1
            }
        } else if dir == 1 {
            x++
            if x == bottom {
                x, y, dir, right = x-1, y-1, 2, right-1
            }
        } else if dir == 2 {
            y--
            if y == left {
                x, y, dir, bottom = x-1, y+1, 3, bottom-1
            }
        } else {
            x--
            if x == top {
                x, y, dir, left = x+1, y+1, 0, left+1
            }
        }
    }
    return result
}
