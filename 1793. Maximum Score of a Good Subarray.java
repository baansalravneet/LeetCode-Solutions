class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        left[k] = nums[k];
        for (int i = k-1; i >= 0; i--) {
            left[i] = Math.min(nums[i], left[i+1]);
        }
        int[] right = new int[n];
        right[k] = nums[k];
        for (int i = k+1; i < n; i++) {
            right[i] = Math.min(nums[i], right[i-1]);
        }
        int i = 0;
        int j = n-1;
        int answer = nums[k];
        while (i <= k && j >= k && i < j) {
            answer = Math.max(answer, Math.min(left[i], right[j]) * (j-i+1));
            if (left[i] < right[j]) {
                i++;
            } else {
                j--;
            }
        }
        return answer;
    }
}
