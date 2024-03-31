class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int badI = -1;
        int minI = -1;
        int maxI = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) badI = i;
            if (nums[i] == minK) minI = i;
            if (nums[i] == maxK) maxI = i;
            answer += Math.max(0, Math.min(minI, maxI) - badI);
        }
        return answer;
    }
}