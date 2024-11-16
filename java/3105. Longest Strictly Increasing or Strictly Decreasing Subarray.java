class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int answer = 1;
        int inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i-1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            answer = Math.max(answer, Math.max(inc, dec));
        }
        return answer;
    }
}
