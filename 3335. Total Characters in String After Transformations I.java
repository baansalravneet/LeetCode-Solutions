class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        while (t-- > 0) {
            long[] newFreq = new long[26];
            for (int i = 0; i < 25; i++) {
                newFreq[i+1] = freq[i];
            }
            newFreq[0] += freq[25];
            newFreq[1] += freq[25];
            freq = newFreq;
            for (int i = 0; i < 25; i++) {
                freq[i] %= MOD;
            }
        }
        int answer = 0;
        for (long i : freq) {
            answer += (int)i;
            answer %= MOD;
        }
        return answer;
    }
}