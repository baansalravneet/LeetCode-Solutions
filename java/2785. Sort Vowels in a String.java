class Solution {
    public String sortVowels(String s) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int A = 0, E = 0, I = 0, O = 0, U = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (c == 'a') a++;
            else if (c == 'e') e++;
            else if (c == 'i') i++;
            else if (c == 'o') o++;
            else if (c == 'u') u++;
            else if (c == 'A') A++;
            else if (c == 'E') E++;
            else if (c == 'I') I++;
            else if (c == 'O') O++;
            else if (c == 'U') U++;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int x = 0; x < s.length(); x++) {
            if (isVowel(s.charAt(x))) {
                if (A != 0) {
                    sb.setCharAt(x, 'A');
                    A--;
                } else if (E != 0) {
                    sb.setCharAt(x, 'E');
                    E--;
                } else if (I != 0) {
                    sb.setCharAt(x, 'I');
                    I--;
                } else if (O != 0) {
                    sb.setCharAt(x, 'O');
                    O--;
                } else if (U != 0) {
                    sb.setCharAt(x, 'U');
                    U--;
                } else if (a != 0) {
                    sb.setCharAt(x, 'a');
                    a--;
                } else if (e != 0) {
                    sb.setCharAt(x, 'e');
                    e--;
                } else if (i != 0) {
                    sb.setCharAt(x, 'i');
                    i--;
                } else if (o != 0) {
                    sb.setCharAt(x, 'o');
                    o--;
                } else if (u != 0) {
                    sb.setCharAt(x, 'u');
                }
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
