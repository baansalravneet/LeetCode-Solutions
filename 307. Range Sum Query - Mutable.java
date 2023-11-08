class NumArray {
    private SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            st.update(i, nums[i], 0, 0, st.n-1);
        }
    }
    
    public void update(int index, int val) {
        st.update(index, val, 0, 0, st.n-1);
    }
    
    public int sumRange(int left, int right) {
        return st.query(left, right, 0, 0, st.n-1);
    }
}

class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4*n];
    }
    
    int query(int left, int right, int treeNode, int nodeLeft, int nodeRight) {
        if (left <= nodeLeft && right >= nodeRight) return tree[treeNode];
        if (left > nodeRight || right < nodeLeft) return 0;
        int mid = (nodeLeft + nodeRight) / 2;
        return query(left, right, 2*treeNode + 1, nodeLeft, mid) +
            query(left, right, 2*treeNode + 2, mid + 1, nodeRight);
    }

    void update(int index, int value, int treeNode, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) tree[treeNode] = value;
        else {
            int mid = (nodeLeft + nodeRight) / 2;
            if (index <= mid) {
                update(index, value, 2*treeNode+1, nodeLeft, mid);
            } else {
                update(index, value, 2*treeNode+2, mid+1, nodeRight);
            }
            tree[treeNode] = tree[2*treeNode+1] + tree[2*treeNode+2];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
