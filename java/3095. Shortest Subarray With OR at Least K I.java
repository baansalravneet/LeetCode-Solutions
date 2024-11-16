class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int current = 0;
            for (int end = start; end < nums.length; end++) {
                current = current | nums[end];
                if (current >= k) answer = Math.min(answer, end - start + 1);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}