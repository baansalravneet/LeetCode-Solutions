class Solution {
    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0;
        int[] freq = new int[26];
        for (char c : word2.toCharArray()) freq[c-'a']++;
        int matched = word2.length();
        long answer = 0;
        int[] current = new int[26];
        for (int left = 0, right = 0; right < word1.length(); right++) {
            current[word1.charAt(right)-'a']++;
            while (left <= right && valid(current, freq)) {
                answer += (long)word1.length() - right;
                current[word1.charAt(left) - 'a']--;
                left++;
            }
        }
        return answer;
    }
    private boolean valid(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) return false;
        }
        return true;
    }
}