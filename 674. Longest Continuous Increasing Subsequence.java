class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int answer = 1;
        for (int i = 0; i < nums.length-1;) {
            int count = 1;
            while (i < nums.length-1) {
                if (nums[i] >= nums[i+1]) break;
                i++;
                count++;
            }
            answer = Math.max(answer, count);
            i++;
        }
        return answer;
    }
}
