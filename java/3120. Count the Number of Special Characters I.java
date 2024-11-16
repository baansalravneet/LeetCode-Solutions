class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c <= 'z' && c >= 'a') {
                lower[c-'a']++;
            } else {
                upper[c-'A']++;
            }
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] > 0 && upper[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}