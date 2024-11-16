class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        for (int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = -1;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c <= 'z' && c >= 'a') {
                lastLower[c-'a'] = i;
                lower[c-'a']++;
            } else {
                if (firstUpper[c-'A'] == -1) firstUpper[c-'A'] = i;
                upper[c-'A']++;
            }
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] > 0 && upper[i] > 0 && lastLower[i] < firstUpper[i]) {
                answer++;
            }
        }
        return answer;
    }
}