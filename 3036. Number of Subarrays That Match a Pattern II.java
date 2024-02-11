class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) sb.append('1');
            else if (nums[i] == nums[i-1]) sb.append('0');
            else sb.append('2');
        }
        StringBuilder p = new StringBuilder();
        for (int i : pattern) {
            if (i == 1) p.append('1');
            else if (i == 0) p.append('0');
            else p.append('2');
        }
        String s = sb.toString();
        String px = p.toString();
        return search(s, px);
    }
    private int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
    private int search(String text, String pattern) {
        int count = 0;
        int[] lps = getLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                count++;
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return count;
    }
}

