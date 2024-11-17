class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int answer = -1;
        int left = 0, right = queries.length;
        while (left <= right) {
            int mid = (left+right)/2;
            boolean valid = valid(nums, queries, mid);
            if (valid) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean valid(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < k; i++) {
            int left = queries[i][0], right = queries[i][1], val = queries[i][2];
            count[left] += val;
            if (right < n-1) count[right+1] -= val;
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += count[i];
            if (current < nums[i]) return false;
        }
        return true;
    }
}