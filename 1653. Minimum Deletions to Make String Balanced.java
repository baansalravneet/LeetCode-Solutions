class Solution {
    public int minimumDeletions(String s) {
        int a = s.charAt(0) == 'a' ? 0 : 1;
        int b = 1-a;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                b = Math.min(a, b+1);
            } else {
                b = Math.min(a, b);
                a++;
            }
        }
        return Math.min(a, b);
    }
}