class Solution {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            String a = s.charAt(i) + "" + s.charAt(i-1);
            if (s.indexOf(a) != -1) return true;
        }
        return false;
    }
}
