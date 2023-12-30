class Solution {

    public int minNumberOperations(int[] target) {
        TreeNode root = getTree(target, 0, target.length-1);
        List<Integer>[] indexes = getIndexes(target);
        return getAnswer(root, indexes, 0, 0, target.length-1, target);
    }

    private List<Integer>[] getIndexes(int[] target) {
        ArrayList<Integer>[] result = new ArrayList[100001];
        for (int i = 0; i < target.length; i++) {
            int index = target[i];
            if (result[index] == null) {
                result[index] = new ArrayList<>();
            }
            result[index].add(i);
        }
        return result;
    }
    
    private int getAnswer(TreeNode root,
                          List<Integer>[] indexes,
                          int current,
                          int left,
                          int right,
                          int[] target) {
        if (left > right) return 0;
        if (left == right) return target[left] - current;
        int minValue = query(root, left, right);
        int result = minValue - current;
        List<Integer> idxes = indexes[minValue];
        for (int i = 0; i < idxes.size()-1; i++) {
            int l = Math.max(left, idxes.get(i)+1);
            int r = Math.min(right, idxes.get(i+1)-1);
            result += getAnswer(root, indexes, minValue, l, r, target);
        }
        result += getAnswer(root, indexes, minValue, left, idxes.get(0)-1, target);
        result += getAnswer(root, indexes, minValue, idxes.get(idxes.size()-1)+1, right, target);
        return result;
    }

    private int query(TreeNode root, int left, int right) {
        // fully overlapping
        if (root.l >= left && root.r <= right) {
            return root.val;
        }
        // not overlapping at all
        if (root.l > right || root.r < left) {
            return 1_000_000;
        }
        return Math.min(query(root.left, left, right), query(root.right, left, right));
    }
    
    private TreeNode getTree(int[] target, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(target[left], left, left);
        }
        int mid = (left+right)/2;
        TreeNode leftChild = getTree(target, left, mid);
        TreeNode rightChild = getTree(target, mid+1, right);
        TreeNode root = new TreeNode(Math.min(leftChild.val, rightChild.val), left, right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
    
}

class TreeNode {

    TreeNode left;
    TreeNode right;
    int l;
    int r;
    int val;

    TreeNode(int val, int l, int r) {
        this.val = val;
        this.l = l;
        this.r = r;
    }

}
