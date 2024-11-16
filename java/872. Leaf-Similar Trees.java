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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = getLeafSeq(root1);
        List<Integer> leafSeq2 = getLeafSeq(root2);
        if (leafSeq1.size() != leafSeq2.size()) return false;
        for (int i = 0; i < leafSeq1.size(); i++) {
            if (leafSeq1.get(i) != leafSeq2.get(i)) return false;
        }
        return true;
    }
    private List<Integer> getLeafSeq(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }
    private void helper(List<Integer> result, TreeNode node) {
        if (node == null) return;
        if (node.left != null) helper(result, node.left);
        if (node.right != null) helper(result, node.right);
        if (node.left == null && node.right == null) {
            result.add(node.val);
        }
    }
}
