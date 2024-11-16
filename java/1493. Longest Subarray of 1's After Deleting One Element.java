class Solution {
    public int longestSubarray(int[] nums) {
        int previous = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; ) {
            int current = nums[i];
            int count = 0;
            while (i < nums.length && current == nums[i]) {
                count++;
                i++;
            }
            if (current == 1) {
                answer = Math.max(answer, count + previous);
                previous = count;
            } else {
                if (count > 1) previous = 0;
            }
        }
        return answer == nums.length ? answer-1 : answer;
    }
}