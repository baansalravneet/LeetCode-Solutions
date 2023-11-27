class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.insert(0, getBit(left, right, i));
        }
        return Integer.parseInt(sb.toString(), 2);
    }
    private char getBit(int left, int right, int index) {
        int rangeSize = right - left + 1;
        int maxSize = (int)Math.pow(2, index);
        if (rangeSize > maxSize) return '0';
        else if (((left & (1 << index)) > 0) && ((right & (1 << index)) > 0)) return '1';
        else return '0';
    }
}
