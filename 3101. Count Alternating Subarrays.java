class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long answer = 0;
        int left = 0;
        for (int i = 0; i < nums.length; ) {
            if (i == left) {
                answer += 1;
                i++;
            } else if (nums[i] != nums[i-1]) {
                answer += i - left + 1;
                i++;
            } else {
                left = i;
            }
        }
        return answer;
    }
}