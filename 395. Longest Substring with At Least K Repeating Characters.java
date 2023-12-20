class Solution {
    public int longestSubstring(String s, int k) {
        // edge cases
        if (k == 1) return s.length();
        if (k > s.length()) return 0;
        return helper(s, 0, s.length()-1, k);
    }

    private int helper(String s, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = left; i <= right; i++) {
            count[s.charAt(i)-'a']++;
        }
        for (int mid = left; mid <= right; mid++) {
            if (count[s.charAt(mid)-'a'] >= k) continue;
            return Math.max(helper(s, left, mid-1, k), helper(s, mid+1, right, k));
        }
        return right - left + 1;
    }
}
