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
    int answer = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return answer;
    }
    private SumCount helper(TreeNode current) {
        if (current == null) return new SumCount(0,0);
        SumCount left = helper(current.left);
        SumCount right = helper(current.right);
        int totalSum = left.sum + right.sum + current.val;
        int totalCount = left.count + right.count + 1;
        if (totalSum / totalCount == current.val) answer++;
        return new SumCount(totalSum, totalCount);
    }
}

class SumCount {
    int sum;
    int count;
    SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
