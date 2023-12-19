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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder source = new StringBuilder();
        StringBuilder target = new StringBuilder();
        getDirectionsFromRoot(root, startValue, source);
        getDirectionsFromRoot(root, destValue, target);
        source.reverse();
        target.reverse();
        int i = 0;
        while (i < source.length() && i < target.length()) {
            if (source.charAt(i) == target.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder("U".repeat(source.length()-i));
        if (i != target.length()) {
            result.append(target.substring(i, target.length()));
        }
        return result.toString();
    }


    private boolean getDirectionsFromRoot(TreeNode root, int target, StringBuilder current) {
        if (root.val == target) {
            return true;
        }
        if (root.left != null && getDirectionsFromRoot(root.left, target, current)) {
            current.append("L");
        } else if (root.right != null && getDirectionsFromRoot(root.right, target, current)) {
            current.append("R");
        }
        return current.length() > 0;
    }
}
