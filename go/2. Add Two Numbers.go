/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{} 
    current, carry := dummy, 0
    for l1 != nil || l2 != nil || carry != 0 {
        value := carry
        if l1 != nil {
            value, l1 = value+l1.Val, l1.Next
        }
        if l2 != nil {
            value, l2 = value+l2.Val, l2.Next
        }
        current.Next, carry = &ListNode {
            Val: value % 10,
        }, value / 10
        current = current.Next
    }
    return (*dummy).Next
}
