/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        populate(root, count);
        List<Integer> answer = new ArrayList<>();
        for (int i : count.keySet()) {
            if (count.get(i) == max) {
                answer.add(i);
            }
        }
        int[] result = new int[answer.size()];
        int index = 0;
        for (int i : answer) result[index++] = i;
        return result;
    }
    private void populate(TreeNode current, Map<Integer, Integer> count) {
        if (current == null) return;
        count.put(current.val, count.getOrDefault(current.val, 0) + 1);
        max = Math.max(max, count.get(current.val));
        populate(current.left, count);
        populate(current.right, count);
    }
}
