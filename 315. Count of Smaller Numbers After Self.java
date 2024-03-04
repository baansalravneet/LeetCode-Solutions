class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i+100000);
            min = Math.min(min, i+100000);
        }
        SegmentTree segmentTree = new SegmentTree(min, max);
        for (int i = nums.length-1; i >= 0; i--) {
            answer.add(segmentTree.find(nums[i]+100000));
            segmentTree.add(nums[i]+100000);
        }
        Collections.reverse(answer);
        return answer;
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
        if (x > this.max) return count;
        int mid = min + (max-min)/2;
        if (x <= mid) {
            if (left == null) return 0;
            return this.left.find(x);
        } else {
            int answer = 0;
            if (left != null) answer += left.find(x);
            if (right != null) answer += right.find(x);
            return answer;
        }
    }

    void add(int x) {
        if (x > max || x < min) return;
        this.count++;
        if (max <= min) return;
        int mid = min + (max-min)/2;
        if (x <= mid) {
            if (left == null) left = new SegmentTree(min, mid);
            left.add(x);
        } else {
            if (right == null) right = new SegmentTree(mid+1, max);
            right.add(x);
        }
        
    }

}
