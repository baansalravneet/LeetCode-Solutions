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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<TreeNode>> answer = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            answer.add(new ArrayList<>(current));
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode c : current) {
                if (c.left != null) next.add(c.left);
                if (c.right != null) next.add(c.right);
            }
            current = next;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = answer.size()-1; i >= 0; i--) {
            List<Integer> level = new ArrayList<>();
            for (TreeNode c : answer.get(i)) {
                level.add(c.val);
            }
            result.add(level);
        }
        return result;
    }
}