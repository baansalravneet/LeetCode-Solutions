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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        ListNode newHead = new ListNode(0, head);
        ListNode pointer = newHead;
        while (head != null) {
            while (head != null && set.contains(head.val)) {
                head = head.next;
            }
            pointer.next = head;
            if (head != null) head = head.next;
            pointer = pointer.next;
        }
        return newHead.next;
    }
}