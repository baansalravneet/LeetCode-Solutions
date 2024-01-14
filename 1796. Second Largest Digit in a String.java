class Solution {
    public int secondHighest(String s) {
        int a = -1;
        int b = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int value = c - '0';
                if (value > a) {
                    b = a;
                    a = value;
                } else if (value > b && value != a) {
                    b = value;
                }
            }
        }
        return a == b ? -1 : b;
    }
}
