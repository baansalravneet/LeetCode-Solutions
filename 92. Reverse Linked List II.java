/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPrev = null; // store the node before left
        ListNode rightNext = null; // store the node after right
        ListNode prev = null; // for reversing
        ListNode pointer = head; // for traversal
        ListNode leftNode = null; // store the node which become the last node of the reversed sublist
        right = right - left;
        while (left-- > 1) {
            leftPrev = pointer;
            pointer = pointer.next;
        }
        // the pointer has moved to the left node
        leftNode = pointer;
        if (leftPrev != null) leftPrev.next = null; // detach the left node
        // start reversing until you find right
        while (right-- > 0) {
            ListNode temp = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = temp;
        }
        rightNext = pointer.next;
        pointer.next = prev;
        if (leftPrev != null) leftPrev.next = pointer;
        leftNode.next = rightNext;
        return leftPrev == null ? pointer : head;
    }
}
