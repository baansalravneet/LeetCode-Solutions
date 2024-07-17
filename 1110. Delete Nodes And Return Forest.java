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
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : toDelete) set.add(i);
        helper(root, null, set, result);
        return result;
    }
    private void helper(TreeNode root, TreeNode previous, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null) return;
        if (previous == null) {
            if (toDelete.contains(root.val)) {
                helper(root.left, null, toDelete, result);
                helper(root.right, null, toDelete, result);
                root.left = null;
                root.right = null;
            } else {
                result.add(root);
            }
        }
        if (root.left != null && toDelete.contains(root.left.val)) {
            helper(root.left, null, toDelete, result);
            root.left = null;
        } else {
            helper(root.left, root, toDelete, result);
        }
        if (root.right != null && toDelete.contains(root.right.val)) {
            helper(root.right, null, toDelete, result);
            root.right = null;
        } else {
            helper(root.right, root, toDelete, result);
        }
    }
}