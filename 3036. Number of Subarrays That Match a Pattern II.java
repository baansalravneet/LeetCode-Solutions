class Solution {
    public int countMatchingSubarrays(int[] n, int[] pattern) {
        int[] lps = getLPS(pattern);
        int count = 0;
        int[] nums = new int[n.length-1];
        for (int i = 1; i < n.length; i++) {
            if (n[i] > n[i-1]) nums[i-1] = 1;
            else if (n[i] < n[i-1]) nums[i-1] = -1;
            else nums[i-1] = 0;
        }
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == pattern[j]) {
                i++;
                j++;
            }
            if (j == pattern.length) {
                count++;
                j = lps[j-1];
            }
            if (i < nums.length && nums[i] != pattern[j]) {
                if (j != 0) j = lps[j-1];
                else i++;
            }
        }
        return count;
    }
    private int[] getLPS(int[] pattern) {
        int[] lps = new int[pattern.length];
        int len = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) lps[i++] = ++len;
            else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}

