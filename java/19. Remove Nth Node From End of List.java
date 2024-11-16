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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reversed = reverse(head);
        if (n == 1) return reverse(reversed.next);
        ListNode pointer = reversed;
        while (n-- > 2) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return reverse(reversed);
    }
    private ListNode reverse(ListNode node) {
        ListNode previous = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = previous;
            previous = node;
            node = temp;
        }
        return previous;
    }
}