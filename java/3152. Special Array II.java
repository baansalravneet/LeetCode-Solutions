class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        nums[0] = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
            prefix[i] = nums[i] != nums[i-1] ? 0 : 1;
            prefix[i] += prefix[i-1];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < answer.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            answer[i] = left == 0 ? prefix[right] == 0 : prefix[right] == prefix[left];
        }
        return answer;
    }
}