class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                answer = Math.min(answer, checkEqual(nums1, nums2, i, j));
            }
        }
        return answer;
    }
    private int checkEqual(int[] nums1, int[] nums2, int x, int y) {
        int i = 0, j = 0;
        int diff = Integer.MAX_VALUE;
        while (i < nums1.length && j < nums2.length) {
            if (i == x || i == y) {
                i++;
                continue;
            }
            if (diff == Integer.MAX_VALUE) {
                diff = nums2[j] - nums1[i];
            }
            if (nums2[j] - nums1[i] != diff) return Integer.MAX_VALUE;
            j++;
            i++;
        }
        return diff;
    }
}