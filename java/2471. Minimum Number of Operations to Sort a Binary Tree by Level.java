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
    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] level = new int[size];
            while (size-- > 0) {
                TreeNode current = q.pollFirst();
                level[level.length-size] = current.val;
                level.add(current.val);
                if (current.left != null) q.addFirst(current.left);
                if (current.right != null) q.addFirst(current.right);
            }
            answer += getSwaps(level);
        }
        return answer;
    }
    private int getSwaps(int[] arr) {
        int swaps = 0;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            positions.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sorted[i]) {
                swaps++;
                int currentPosition = positions.get(target[i]);
                int currentValue = arr[i];
                arr[i] = sorted[i];
                arr[currentPosition] = currentValue;
                positions.put(currentValue, currentPosition);
            }
        }
        return swaps;
    }
}
