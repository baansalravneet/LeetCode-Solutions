class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) set.add(word);
        Integer[] cache = new Integer[s.length()];
        return helper(s, 0, set, cache);
    }
    private int helper(String s, int index, Set<String> set, Integer[] cache) {
        if (index >= s.length()) return 0;
        if (cache[index] != null) return cache[index];
        int answer = 1 + helper(s, index+1, set, cache);
        for (int i = index+1; i <= s.length(); i++) {
            if (set.contains(s.substring(index, i))) {
                answer = Math.min(answer, helper(s, i, set, cache));
            }
        }
        return cache[index] = answer;
    }
}