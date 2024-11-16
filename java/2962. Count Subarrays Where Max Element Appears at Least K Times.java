class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        int count = 0;
        long answer;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == max)  count++;
            while (count >= k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            answer += left;
        }
        return answer;
    }
}