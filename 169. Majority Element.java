class Solution {
    public int majorityElement(int[] nums) {
        int answer = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == answer) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                answer = nums[i];
                count = 1;
            }
        }
        return answer;
    }
}
