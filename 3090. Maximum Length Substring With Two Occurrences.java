class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(find(s, i), max);
        }
        return max;
    }
    private int find(String s, int start) {
        int[] freq = new int[26];
        int length = 0;
        for (int i = start; i < s.length(); i++) {
            if (freq[s.charAt(i)-'a'] == 2) return length;
            freq[s.charAt(i)-'a']++;
            length++;
        }
        return length;
    }
}

