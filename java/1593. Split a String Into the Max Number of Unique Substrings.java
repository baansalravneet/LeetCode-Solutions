class Solution {
    public int maxUniqueSplit(String s) {
        return helper(s, new HashSet<>(), 0);
    }
    private int helper(String s, Set<String> set, int index) {
        if (index >= s.length()) return 0;
        int answer = 0;
        for (int i = index+1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (set.contains(substring)) continue;
            set.add(substring);
            answer = Math.max(answer, 1 + helper(s, set, i));
            set.remove(substring);
        }
        return answer;
    }
}
