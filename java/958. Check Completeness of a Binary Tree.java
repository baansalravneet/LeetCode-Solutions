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
    public boolean isCompleteTree(TreeNode root) {
        // level order
        // we know how many nodes are supposed to be there at each level
        // level 0 - 1
        // level 1 - 2
        // level 2 - 4 ...
        // at the first incomplete level, we check if all of them are leaf nodes
        // we also need to check if all the leaves are on the left
        // we can keep track of the null nodes and the count of nodes at each level
        if (root == null) return true;
        Deque<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        int count = 1;
        int levelCount = 0;
        while (!level.isEmpty()) {
            // non compelete
            if (count != Math.pow(2, levelCount)) {
                return checkLastLevel(level);
            }
            count = 0;
            levelCount += 1;
            Deque<TreeNode> nextLevel = new LinkedList<>();
            while (!level.isEmpty()) {
                TreeNode current = level.pollFirst();
                if (current.val == -1) {
                    continue;
                }
                if (current.left == null) {
                    nextLevel.addLast(new TreeNode(-1));
                } else {
                    nextLevel.addLast(current.left);
                    count += 1;
                }
                if (current.right == null) {
                    nextLevel.addLast(new TreeNode(-1));
                } else {
                    nextLevel.addLast(current.right);
                    count += 1;
                }
            }
            level = nextLevel;
        }
        return true;
    }
    private boolean checkLastLevel(Deque<TreeNode> level) {
        boolea nullFound = false;
        while (!level.isEmpty()) {
            TreeNode current = level.pollFirst();
            if (nullFound && current.val != -1) return false;
            if (current.val == -1) {
                nullFound = true;
            } else {
                if (current.left != null || current.right != null) return false;
            }
        }
        return true;
    }
}

