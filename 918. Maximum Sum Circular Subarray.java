class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            answer = Math.max(answer, i);
        }
        if (answer <= 0) return answer;
        
        answer = Math.max(answer, getMaxSumSubarray(nums));
        answer = Math.max(answer, sum - getMinSumSubarray(nums));
        return answer;
    }
    private int getMaxSumSubarray(int[] nums) {
        int answer = 0;
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
            if (currentSum < 0) currentSum = 0;
            answer = Math.max(answer, currentSum);
        }
        return answer;
    }
    private int getMinSumSubarray(int[] nums) {
        int answer = 0;
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
            if (currentSum > 0) currentSum = 0;
            answer = Math.min(answer, currentSum);
        }
        return answer;
    }
}
