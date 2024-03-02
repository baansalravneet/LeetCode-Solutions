class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int x = 0;
        for (int i : nums) {
            if (i >= 0) break;
            x++;
        }
        int i = x, j = x-1, k = 0;
        while (k < answer.length) {
            if (i < nums.length && (j < 0 || nums[i] * nums[i] <= nums[j] * nums[j])) {
                answer[k++] = nums[i] * nums[i];
                i++;
            } else {
                answer[k++] = nums[j] * nums[j];
                j--;
            }
        }
        return answer;
    }
}