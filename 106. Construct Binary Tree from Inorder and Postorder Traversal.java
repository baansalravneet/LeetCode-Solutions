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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return helper(inorderIndex, inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    private TreeNode helper
    (
        Map<Integer, Integer> inorderIndex,
        int[] inorder,
        int[] postorder,
        int start,
        int end,
        int postorderIndex
    )
    {
        if (start > end) return null;
        if (start == end) return new TreeNode(inorder[start]);
        int current = postorder[postorderIndex];
        int i = inorderIndex.get(current);
        TreeNode result = new TreeNode(current);
        result.right = helper(inorderIndex, inorder, postorder, i+1, end, postorderIndex-1);
        int rightLength = end - i;
        result.left = helper(inorderIndex, inorder, postorder, start, i-1, postorderIndex - rightLength - 1);
        return result;
    }
}
