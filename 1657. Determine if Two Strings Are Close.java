class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] freq1 = getFreq(word1);
        int[] freq2 = getFreq(word2);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0 && freq2[i] != 0) return false;
            if (freq2[i] == 0 && freq1[i] != 0) return false;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        return freq;
    }
}
