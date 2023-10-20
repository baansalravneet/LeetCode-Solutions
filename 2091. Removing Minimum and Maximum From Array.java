class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int minValueIndex = 0;
        int maxValueIndex = 0;
        for (int i = 0; i < n; i++) {
            if (minValue > nums[i]) {
                minValue = nums[i];
                minValueIndex = i;
            }
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        if (minValueIndex == maxValueIndex) {
            return Math.min(minValueIndex+1, n - minValueIndex);
        }
        int answer = Integer.MAX_VALUE;
        // remove all left
        answer = Math.min(answer, Math.max(minValueIndex, maxValueIndex) + 1);
        // remove all right
        answer = Math.min(answer, n - Math.min(minValueIndex, maxValueIndex));
        // remove left and right
        answer = Math.min(answer, Math.min(minValueIndex, maxValueIndex)+1+n-Math.max(minValueIndex, maxValueIndex));
        return answer;
    }
}
