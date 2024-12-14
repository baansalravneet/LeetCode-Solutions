class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int answer = 0;
        while (right < nums.length) {
            if (nums[right]-k <= nums[left]+k) {
                right++;
            } else {
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        return answer;
    }
}
