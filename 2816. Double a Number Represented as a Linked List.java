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
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode newHead = new ListNode();
        ListNode pointer = newHead;
        int carry = 0;
        while (reversed != null) {
            pointer.next = new ListNode((reversed.val * 2 + carry) % 10);
            carry = (reversed.val*2 + carry) / 10;
            reversed = reversed.next;
            pointer = pointer.next;
        }
        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }
        return reverse(newHead.next);
    }
    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        return previous;
    }
}