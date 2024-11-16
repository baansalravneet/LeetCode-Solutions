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
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return String.valueOf(root.val);
        String answer = String.valueOf(root.val);
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (left.equals("") && right.equals("")) {
            return answer;
        }
        answer = answer + "(" + left + ")";
        if (!right.equals("")) {
            answer = answer + "(" + right + ")";
        }
        return answer;
    }
}
