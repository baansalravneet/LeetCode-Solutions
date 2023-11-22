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
class BSTIterator {
    List<Integer> inOrder;
    int pointer;

    public BSTIterator(TreeNode root) {
        inOrder = new ArrayList<>();
        populate(inOrder, root);
        pointer = 0;
    }

    private void populate(List<Integer> inOrder, TreeNode root) {
        if (root == null) return;
        populate(inOrder, root.left);
        inOrder.add(root.val);
        populate(inOrder, root.right);
    }
    
    public int next() {
        return inOrder.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer < inOrder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 *
