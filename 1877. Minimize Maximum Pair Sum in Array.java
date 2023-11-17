class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n/2; i++) {
            answer = Math.max(answer, nums[i] + nums[n-1-i]);
        }
        return answer;
    }
}
