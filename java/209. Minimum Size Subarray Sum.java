class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        long windowSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                answer = Math.min(answer, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
