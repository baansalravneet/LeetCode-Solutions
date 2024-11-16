/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func splitListToParts(head *ListNode, k int) []*ListNode {
    count := getCount(head)
    n, remain, index := count/k, count%k, 0
    result := make([]*ListNode, k, k)
    for head != nil {
        result[index] = head
        index++
        group := 0
        if remain > 0 {
            group = n+1
            remain--
        } else {
            group = n
        }
        for group > 1 {
            head = head.Next
            group--
        }
        head, head.Next = head.Next, nil
    }
    return result
}

func getCount(head *ListNode) int {
    count := 0
    for head != nil {
        count++
        head = head.Next
    }
    return count
}

