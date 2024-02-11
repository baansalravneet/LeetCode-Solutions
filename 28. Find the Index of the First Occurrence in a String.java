class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = getLPS(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) return i-needle.length();
            if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) j = lps[j-1];
                else i++;
            }
        }
        return -1;
    }
    private int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 1;
        int len = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len != 0) len = lps[len-1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}
