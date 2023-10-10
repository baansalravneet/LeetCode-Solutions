class Solution {
    public int longestNiceSubarray(int[] nums) {
        int answer = 1;
        int left = 0;
        int currentOnes = 0;
        for (int right = 0; right < nums.length; right++) {
            while (left < right && (currentOnes & nums[right]) != 0) {
                currentOnes -= nums[left];
                left++;
            }
            currentOnes |= nums[right];
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
