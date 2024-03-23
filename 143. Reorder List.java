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
    public void reorderList(ListNode head) {
        // find the mid
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut the list
        ListNode second = slow.next;
        slow.next = null;

        // reverse the second half
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // put the 2 lists together
        ListNode head2 = head;
        while (prev != null) {
            ListNode temp = head2.next;
            ListNode temp2 = prev.next;
            head2.next = prev;
            prev.next = temp;
            head2 = temp;
            prev = temp2;
        }
    }
}
