class RangeFreqQuery {

    SegmentTreeNode st;

    public RangeFreqQuery(int[] arr) {
        st = SegmentTreeNode.buildTree(arr, 0, arr.length-1);
    }
    
    public int query(int left, int right, int value) {
        return queryUtil(left, right, value, st);
    }

    private int queryUtil(int left, int right, int value, SegmentTreeNode st) {
        if (st.left >= left && st.right <= right) return st.freqMap.getOrDefault(value, 0);
        if (left > st.right || right < st.left) return 0;
        int mid = (st.left + st.right) / 2;
        return queryUtil(left, right, value, st.leftChild) +
            queryUtil(left, right ,value, st.rightChild);
    }
}

class SegmentTreeNode {
    int left, right;
    SegmentTreeNode leftChild, rightChild;
    Map<Integer, Integer> freqMap;

    SegmentTreeNode(int left, int right, int element) {
        freqMap = new HashMap<>();
        freqMap.put(element, 1);
        this.left = left;
        this.right = right;
    }

    SegmentTreeNode(int left, int right, SegmentTreeNode leftNode, SegmentTreeNode rightNode) {
        this.left = left;
        this.right = right;
        freqMap = new HashMap<>(leftNode.freqMap);
        rightNode.freqMap.forEach((k, v) -> freqMap.merge(k, v, Integer::sum));
        leftChild = leftNode;
        rightChild = rightNode;
    }

    static SegmentTreeNode buildTree(int[] arr, int left, int right) {
        if (left == right) return new SegmentTreeNode(left, right, arr[left]);
        int mid = (left + right) / 2;
        return new SegmentTreeNode
        (
            left,
            right,
            buildTree(arr, left, mid),
            buildTree(arr, mid+1, right)
        );
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
