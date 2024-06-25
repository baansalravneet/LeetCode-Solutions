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
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }
    private int helper(TreeNode root, int value) {
        if (root == null) return 0;
        int rightValue = helper(root.right, value);
        int leftValue = helper(root.left, value + root.val + rightValue);
        int subtreeSum = rightValue + leftValue + root.val;
        root.val += value + rightValue;
        return subtreeSum;
    }
}
