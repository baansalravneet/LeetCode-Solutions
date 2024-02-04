class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int matched = 0;
        int start = -1;
        int length = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c)-1);
                if (freq.get(c) == 0) matched++;
            }
            while (matched == freq.size()) {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    start = left;
                }
                char deleted = s.charAt(left);
                if (freq.containsKey(deleted)) {
                    if (freq.get(deleted) == 0) matched--;
                    freq.put(deleted, freq.get(deleted) + 1);
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + length);
    }
}
