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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left > right) return result;
        if (left == right) {
            result.add(new TreeNode(left));
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = helper(left, i-1);
            List<TreeNode> rights = helper(i+1, right);
            if (lefts.isEmpty()) {
                for (TreeNode sub : rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = sub;
                    result.add(root);
                }
            } else if (rights.isEmpty()) {
                for (TreeNode sub : lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = sub;
                    result.add(root);
                }
            } else {
                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
