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
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root) {
        if (root == null) return root;
        if (root.left == null) {
            helper(root.right);
            return root;
        }
        if (root.right == null) {
            TreeNode flatLeft = helper(root.left);
            root.left = null;
            root.right = flatLeft;
            return root;
        }
        TreeNode flatRight = helper(root.right);
        TreeNode flatLeft = helper(root.left);
        root.left = null;
        TreeNode pointer = root;
        root.right = flatLeft;
        while (pointer.right != null) pointer = pointer.right;
        pointer.right = flatRight;
        return root;
    }
}
