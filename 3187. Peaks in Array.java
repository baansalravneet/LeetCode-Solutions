class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        SegmentTree st = new SegmentTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (checkPeak(nums, i)) {
                st.update(i, 1, 1, 0, nums.length-1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                result.add(st.query(query[1]+1, query[2]-1, 0, nums.length-1, 1));
            } else {
                int index = query[1];
                nums[index] = query[2];
                for (int i = index-1; i <= index+1; i++) {
                    if (checkPeak(nums, i)) {
                        st.update(i, 1, 1, 0, nums.length-1);
                    } else {
                        st.update(i, 0, 1, 0, nums.length-1);
                    }
                }
            }
        }
        return result;
    }
    private boolean checkPeak(int[] nums, int i) {
        return i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }
}

class SegmentTree {
    int[] tree;

    SegmentTree(int n) {
        tree = new int[4*n];
    }
    
    int query(int queryLeft, int queryRight, int left, int right, int treeNode) {
        if (left > right) return 0;
        if (queryRight < left || queryLeft > right) return 0;
        if (queryLeft <= left && queryRight >= right) return tree[treeNode];
        int mid = (left + right) / 2;
        return query(queryLeft, queryRight, left, mid, 2*treeNode) +
            query(queryLeft, queryRight, mid+1, right, 2*treeNode+1);
    }

    void update(int index, int value, int treeNode, int left, int right) {
        if (treeNode >= tree.length) return;
        if (index < left || index > right) return;
        if (left > right) return;
        if (left == right) {
            tree[treeNode] = value;
            return;
        }
        int mid = (left+right)/2;
        update(index, value, 2*treeNode, left, mid);
        update(index, value, 2*treeNode+1, mid+1, right);
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1]; 
    }
}

