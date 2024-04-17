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
    private String answer = Character.toString((char)((int)'z'+1));
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return answer;
    }
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.insert(0, (char)(root.val + (int)'a'));
        if (root.left == null && root.right == null) {
            String result = sb.toString();
            answer = answer.compareTo(result) < 1 ? answer : result;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(0);
    }
}