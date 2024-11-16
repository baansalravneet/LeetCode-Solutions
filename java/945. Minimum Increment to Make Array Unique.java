class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int currentMax = -1;
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            int x = i;
            while (x < nums.length && nums[x] == num) {
                if (nums[x] <= currentMax) {
                    currentMax++;
                    answer += currentMax - nums[x];
                } else {
                    currentMax = nums[i];
                }
                x++;
            }
            i = x;
        }
        return answer;
    }
}
