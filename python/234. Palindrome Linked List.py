# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        mid = self.get_middle(head)
        reversed = self.reverse(mid.next)
        while head and reversed:
            if head.val != reversed.val:
                return False
            head = head.next
            reversed = reversed.next
        return True
    def reverse(self, head):
        previous = None
        while head:
            temp = head.next
            head.next = previous
            previous = head
            head = temp
        return previous
    def get_middle(self, head):
        length = self.get_length(head)
        while length > 0:
            head = head.next
            length -= 1
        return head
    def get_length(self, head):
        length = 0
        while head:
            length += 1
            head = head.next
        return length//2-1
        

