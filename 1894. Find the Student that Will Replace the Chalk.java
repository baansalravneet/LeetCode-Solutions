class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;
        for (int i : chalk) total += (long)i;
        k %= total;
        for (int i = 0; i < n; i++) {
            if (chalk[i] > k) return i;
            k -= chalk[i];
        }
        return -1;
    }
}