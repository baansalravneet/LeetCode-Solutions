class Solution {
    public int[] resultArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        SegmentTree tree1 = new SegmentTree(min, max);
        SegmentTree tree2 = new SegmentTree(min, max);
        list1.add(nums[0]); tree1.add(nums[0]);
        list2.add(nums[1]); tree2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int g1 = tree1.find(nums[i]);
            int g2 = tree2.find(nums[i]);
            if (g1 < g2) {
                list2.add(nums[i]);
                tree2.add(nums[i]);
            }
            else if (g1 > g2) {
                list1.add(nums[i]);
                tree1.add(nums[i]);
            } else {
                if (list1.size() <= list2.size()) {
                    list1.add(nums[i]);
                    tree1.add(nums[i]);
                } else {
                    list2.add(nums[i]);
                    tree2.add(nums[i]);
                }
            }
        }
        int[] result = new int[nums.length];
        int index = 0;
        for (int i : list1) result[index++] = i;
        for (int i : list2) result[index++] = i;
        return result;
    }
}

class SegmentTree {
    int min;
    int max;
    int count;
    SegmentTree left;
    SegmentTree right;

    SegmentTree(int min, int max) {
        this.min = min;
        this.max = max;
    }

    int find(int x) {
        if (x < min) return count;
        if (x > max) return 0;
        int answer = 0;
        if (right != null) answer += right.find(x);
        if (left != null) answer += left.find(x);
        return answer;
    }

    void add(int x) {
        count++;
        if (min >= max) return;
        int mid = min + (max - min) / 2;
        if (x <= mid) {
            if (left == null) left = new SegmentTree(min, mid);
            left.add(x);
        } else {
            if (right == null) right = new SegmentTree(mid+1, max);
            right.add(x);
        }
    }
}


