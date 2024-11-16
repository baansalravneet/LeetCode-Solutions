class Solution {
    public boolean isIsomorphic(String s, String t) {
        return helper(s,t) && helper(t,s);
    }
    private boolean helper(String s, String t) {
        char[] mapping = new char[255];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (mapping[c] == 0) mapping[c] = t.charAt(i);
            else if (mapping[c] != t.charAt(i)) return false;
        }
        return true;
    }
}
