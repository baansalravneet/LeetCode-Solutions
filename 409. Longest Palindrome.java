class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int answer = 0;
        boolean odd = false;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 0) answer += freq[i];
            else {
                if (odd) {
                    answer += freq[i] - 1;
                } else {
                    answer += freq[i];
                    odd = true;
                }
            }
        }
        return answer;
    }
}