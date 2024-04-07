class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        return helper(s, 0, 0, cache);
    }
    private boolean helper(String s, int index, int count, Boolean[][] cache) {
        if (index == s.length()) {
            return count == 0;
        }
        if (count < 0) return false;
        if (cache[index][count] != null) return cache[index][count];
        if (s.charAt(index) == ')') return cache[index][count] = helper(s, index+1, count-1, cache);
        if (s.charAt(index) == '(') return cache[index][count] = helper(s, index+1, count+1, cache);
        return cache[index][count] = (helper(s, index+1, count+1, cache)
                || helper(s, index+1, count-1, cache)
                || helper(s, index+1, count, cache));
    }
}
