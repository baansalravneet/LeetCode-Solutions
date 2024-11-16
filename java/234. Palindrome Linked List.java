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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddle(head);
        ListNode reversed = reverse(mid.next);
        while (head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
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
    private ListNode getMiddle(ListNode head) {
        int length = getLength(head);
        while (length-- > 0) head = head.next;
        return head;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length/2-1;
    }
}

