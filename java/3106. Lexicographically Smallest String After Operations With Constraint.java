class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (k == 0) {
                sb.append(c);
                continue;
            }
            if (k < 'z'+1-c) {
                if (k >= c-'a') {
                    sb.append('a');
                    k -= c-'a';
                } else {
                    sb.append((char)(c-k));
                    k = 0;
                }
                continue;
            }
            sb.append('a');
            if (c-'a'<'z'+1-c && k >= c-'a') {
                k -= c-'a';
            } else {
                k -= 'z'+1-c;
            }
        }
        return sb.toString();
    }
}