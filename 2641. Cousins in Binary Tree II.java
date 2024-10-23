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
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> level = new ArrayDeque<>();
        level.addLast(root);
        List<Integer> levelSums = new ArrayList<>();
        while (!level.isEmpty()) {
            int size = level.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode current = level.pollFirst();
                sum += current.val;
                if (current.left != null) level.addLast(current.left);
                if (current.right != null) level.addLast(current.right);
            }
            levelSums.add(sum);
        }
        int currentLevel = 0;
        level.addLast(root);
        while (!level.isEmpty()) {
            int size = level.size();
            while (size-- > 0) {
                TreeNode current = level.pollFirst();
                if (current.left != null) level.addLast(current.left);
                if (current.right != null) level.addLast(current.right);
                if (currentLevel < levelSums.size()-1) {
                    int cousinSum = levelSums.get(currentLevel+1);
                    if (current.left != null) cousinSum -= current.left.val;
                    if (current.right != null) cousinSum -= current.right.val;
                    if (current.left != null) current.left.val = cousinSum;
                    if (current.right != null) current.right.val = cousinSum;
                }
            }
            currentLevel++;
        }
        root.val = 0;
        return root;
    }
}