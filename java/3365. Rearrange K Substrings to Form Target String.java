class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int len = n/k;
        if (len == 1) return true;
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i += len) {
            String sub = s.substring(i, i+len);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
        }
        for (int i = 0; i < n; i += len) {
            String sub = t.substring(i, i+len);
            if (freq.getOrDefault(sub, 0) > 0) {
                freq.put(sub, freq.get(sub) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}