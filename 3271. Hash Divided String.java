class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            int sum = 0, count = k;
            while (count-- > 0) {
                sum += s.charAt(i++) - 'a';
            }
            sb.append((char)(sum%26 + 'a'));
        }
        return sb.toString();
    }
}