class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, size = 0, right = 0, count = 0, left = 0;
        for (int i = 0; i < n; i++) {
            size += nums[i];
        }
        while (right < size) count += 1-nums[right++];
        int answer = count;
        while (left < n) {
            count += 1-nums[(right++) % n];
            count -= 1-nums[left++];
            answer = Math.min(answer, count);
        }
        return answer;
    }
}