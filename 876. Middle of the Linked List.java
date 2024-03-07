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
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        length /= 2;
        while (length-- > 0) head = head.next;
        return head;
    }
    private int getLength(ListNode pointer) {
        int count = 0;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }
}
