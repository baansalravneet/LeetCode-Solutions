class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] reqFreq = new int[26];
        for (String w : words2) {
            int[] freq = getFreq(w);
            for (int i = 0; i < 26; i++) {
                reqFreq[i] = Math.max(reqFreq[i], freq[i]);
            }
        }
        List<String> answer = new ArrayList<>();
        OUTER: for (String w : words1) {
            int[] freq = getFreq(w);
            for (int i = 0; i < 26; i++) {
                if (freq[i] < reqFreq[i]) {
                    continue OUTER;
                }
            }
            answer.add(w);
        }
        return answer;
    }
    private int[] getFreq(String w) {
        int[] freq = new int[26];
        for (char c : w.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}