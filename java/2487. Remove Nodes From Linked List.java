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
    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode pointer = reversed;
        while (pointer != null) {
            while (pointer.next != null && pointer.next.val < pointer.val) {
                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
        }
        return reverse(reversed);
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}