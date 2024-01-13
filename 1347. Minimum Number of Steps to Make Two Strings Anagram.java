class Solution {
    public int minSteps(String s, String t) {
        int[] freqS = getFreq(s);
        int[] freqT = getFreq(t);
        int answer = s.length();
        for (int i = 0; i < 26; i++) {
            answer -= Math.min(freqS[i], freqT[i]);
        }
        return answer;
    }
    private int[] getFreq(String s) {
        int[] result = new int[26];
        for (char c : s.toCharArray()) {
            result[c-'a']++
        }
        return result;
    }
}
