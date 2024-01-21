class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        if (length <= 8) return length;
        if (length <= 16) return 2*(length-8)+8;
        if (length <= 24) return 3*(length-16)+2*8 + 8;
        return 4*(length-24)+3*8+2*8+8;
    }
}
