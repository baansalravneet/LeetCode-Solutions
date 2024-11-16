class Solution {
    public int minOperations(String s) {
        int zeroStart = 0;
        int oneStart = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (flag) zeroStart++;
                else oneStart++;
            } else {
                if (flag) oneStart++;
                else zeroStart++;
            }
            flag = !flag;
        }
        return Math.min(zeroStart, oneStart);
    }
}
