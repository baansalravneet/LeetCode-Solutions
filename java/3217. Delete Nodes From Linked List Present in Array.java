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
        ListNode newHead = new ListNode();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        ListNode pointer = newHead;
        while (head != null) {
            if (!set.contains(head.val)) {
                pointer.next = head;
                pointer = pointer.next;
            }
            head = head.next;
        }
        pointer.next = null;
        return newHead.next;
    }
}
