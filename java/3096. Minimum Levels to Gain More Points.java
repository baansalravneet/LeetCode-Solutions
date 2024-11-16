class Solution {
    public int minimumLevels(int[] possible) {
        int total = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i] == 0) possible[i] = -1;
            total += possible[i];
        }
        int sum = 0;
        for (int i = 0; i < possible.length-1; i++) {
            sum += possible[i];
            total -= possible[i];
            if (sum > total) return i+1;
        }
        return -1;
    }
}