class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
        int i1 = 0, i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            char a = s1.charAt(i1);
            char b = s2.charAt(i2);
            if (a == b || (a+1 == b) || (a=='z' && b=='a')) {
                i2++;
            }
            i1++;
        }
        return i2 == s2.length();
    }
}