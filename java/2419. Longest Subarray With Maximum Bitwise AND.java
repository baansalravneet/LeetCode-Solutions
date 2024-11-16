class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for (int i : nums) max = Math.max(i, max);
        int count = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) count = 0;
            else count++;
            answer = Math.max(answer, count);
        }
        return answer;
    }
}