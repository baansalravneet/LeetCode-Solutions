# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reversed = self.reverse(head)
        newHead = ListNode(0)
        pointer = newHead
        carry = 0
        while reversed:
            pointer.next = ListNode((reversed.val * 2 + carry) % 10)
            carry = (reversed.val * 2 + carry) // 10
            reversed = reversed.next
            pointer = pointer.next
        if carry:
            pointer.next = ListNode(carry)
        return self.reverse(newHead.next)
    def reverse(self, head):
        prev = None
        while head:
            head.next, prev, head = prev, head, head.next
        return prev