class Solution {
    public int minimumSubstringsInPartition(String s) {
        Integer[] cache = new Integer[s.length()];
        return helper(s, 0, cache);
    }
    private int helper(String s, int index, Integer[] cache) {
        if (index == s.length()) return 0;
        if (cache[index] != null) return cache[index];
        int[] freq = new int[26];
        int answer = s.length();
        for (int i = index; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            freq[c] += 1;
            if (check(freq)) {
                answer = Math.min(answer, 1 + helper(s, i+1, cache));
            }
        }
        return cache[index] = answer;
    }
    private boolean check(int[] freq) {
        int min = 100000, max = -1;
        for (int i : freq) {
            if (i > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return min == max;
    }
}