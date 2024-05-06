class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int maxFreq = 0;
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i += k) {
            String sub = word.substring(i, i+k);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(sub));
        }
        return word.length() / k - maxFreq;
    }
}