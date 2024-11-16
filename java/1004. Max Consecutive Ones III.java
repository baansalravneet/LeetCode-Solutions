class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZeros = 0;
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) countZeros++;
            while (countZeros > k) {
                countZeros -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
