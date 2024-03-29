class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[0] ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            result[0] ^= encoded[i];
        }
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] ^ encoded[i-1];
        }
        return result;
    }
}
