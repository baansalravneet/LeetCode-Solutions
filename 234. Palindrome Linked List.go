/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
    mid := getMiddle(head)
    reversed := reverse(mid.Next)
    for head != nil && reversed != nil {
        if (head.Val != reversed.Val) {
            return false
        }
        head = head.Next
        reversed = reversed.Next
    }
    return true
}

func reverse(head *ListNode) *ListNode {
    var previous *ListNode
    for head != nil {
        temp := head.Next
        head.Next = previous
        previous= head
        head = temp
    }
    return previous
}

func getMiddle(head *ListNode) *ListNode {
    length := getLength(head)
    for length > 0 {
        head = head.Next
        length -= 1
    }
    return head
}

func getLength(head *ListNode) int {
    length := 0
    for head != nil {
        length += 1
        head = head.Next
    }
    return length/2-1
}

