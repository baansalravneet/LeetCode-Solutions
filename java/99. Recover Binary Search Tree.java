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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        getInorder(root, inorder);
        for (int i = 0; i < inorder.size()-1; i++) {
            if (inorder.get(i).val > inorder.get(i+1).val) {
                int temp = inorder.get(i).val;
                inorder.get(i).val = inorder.get(i+1).val;
                inorder.get(i+1).val = temp;
            }
        }
        for (int i = inorder.size()-1; i >= 1; i--) {
            if (inorder.get(i).val < inorder.get(i-1).val) {
                int temp = inorder.get(i).val;
                inorder.get(i).val = inorder.get(i-1).val;
                inorder.get(i-1).val = temp;
            }
        }
    }
    private void getInorder(TreeNode current, List<TreeNode> inorder) {
        if (current == null) return;
        getInorder(current.left, inorder);
        inorder.add(current);
        getInorder(current.right, inorder);
    }
}