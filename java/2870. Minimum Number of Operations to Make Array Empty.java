class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; ) {
            int rep = nums[i];
            int count = 0;
            while (i < nums.length && nums[i] == rep) {
                i++;
                count++;
            }
            if (count == 1) return -1;
            answer += (int)Math.ceil((double)count/3);
        }
        return answer;
    }
}

