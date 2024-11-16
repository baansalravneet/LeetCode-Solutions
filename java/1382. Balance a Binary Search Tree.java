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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        populate(nodes, root);
        return balanced(nodes, 0, nodes.size()-1);
    }
    private TreeNode balanced(List<TreeNode> nodes, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            TreeNode current = nodes.get(left);
            current.left = null;
            current.right = null;
            return current;
        }
        int mid = (left + right) / 2;
        TreeNode current = nodes.get(mid);
        current.left = balanced(nodes, left, mid-1);
        current.right = balanced(nodes, mid+1, right);
        return current;
    }
    private void populate(List<TreeNode> nodes, TreeNode root) {
        if (root == null) return;
        populate(nodes, root.left);
        nodes.add(root);
        populate(nodes, root.right);
    }
}
