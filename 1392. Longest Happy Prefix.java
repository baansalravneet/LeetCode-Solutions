class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int i = 1;
        int len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len-1];
                } else {
                    len = 0;
                    i++;
                }
            }
        }
        return s.substring(s, lps[s.length()-1]);
    }
}
