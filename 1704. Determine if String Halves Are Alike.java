class Solution {
    public boolean halvesAreAlike(String s) {
        int freq1 = getFreq(s, 0, s.length()/2 - 1);
        int freq2 = getFreq(s, s.length()/2, s.length()-1);
        return freq1 == freq2;
    }
    private int getFreq(String s, int left, int right) {
        int freq = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(s.charAt(i))) {
                freq++;
            }
        }
        return freq;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' ||
            c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
