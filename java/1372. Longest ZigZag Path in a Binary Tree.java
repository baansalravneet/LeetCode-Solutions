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
    private int answer = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, true);
        return answer-1;
    }
    // counting nodes
    private int helper(TreeNode root, boolean left) {
        if (root == null) return 0;
        int l = 1+helper(root.left, false);
        int r = 1+helper(root.right, true);
        answer = Math.max(answer, Math.max(l, r));
        if (left) return l;
        return r;
    }
}