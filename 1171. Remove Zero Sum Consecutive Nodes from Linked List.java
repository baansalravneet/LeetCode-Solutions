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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        ListNode pointer = head;
        int sum = 0;
        while (pointer != null) {
            sum += pointer.val;
            pointer = pointer.next;
            if (sum == 0) return removeZeroSumSublists(pointer);
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}


