class Solution {
    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0L;
        int[] freq = new int[26];
        for (char c : word2.toCharArray()) {
            freq[c-'a']++;
        }
        int[][] prefix = new int[word1.length()][26];
        prefix[0][word1.charAt(0)-'a']++;
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 0; j < 26; j++) {
                prefix[i][j] = prefix[i-1][j];
            }
            prefix[i][word1.charAt(i)-'a']++;
        }
        long answer = 0;
        for (int i = 0; i <= word1.length()-word2.length(); i++) {
            int left = i;
            int right = word1.length()-1;
            int index = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (valid(prefix, i, mid, freq)) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (index != -1) answer += word1.length() - index;
        }
        return answer;
    }
    private boolean valid(int[][] prefix, int left, int right, int[] freq) {
        for (int i = 0; i < 26; i++) {
            int count = left == 0 ? prefix[right][i] : prefix[right][i] - prefix[left-1][i];
            if (count < freq[i]) return false;
        }
        return true;
    }
}