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
    private int answer = Integer.MAX_VALUE;
    private Integer previous;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return answer;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (previous != null) answer = Math.min(answer, root.val - previous);
        previous = root.val;
        inorder(root.right);
    }
}
