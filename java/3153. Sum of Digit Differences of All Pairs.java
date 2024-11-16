class Solution {
    public long sumDigitDifferences(int[] nums) {
        int[][] freq = new int[9][10];
        for (int n : nums) {
            for (int i = 1; i < 1000000000; i*=10) {
                int digit = (n/i)%10;
                int position = findPosition(i);
                freq[position][digit]++;
            }
        }
        long answer = 0;
        for (int pos = 0; pos < 9; pos++) {
            for (int i = 0; i < 10; i++) {
                for (int j = i+1; j < 10; j++) {
                    answer += (long)freq[pos][i] * (long)freq[pos][j];
                }
            }
        }
        return answer;
    }
    private int findPosition(int i) {
        if (i == 1) return 0;
        if (i == 10) return 1;
        if (i == 100) return 2;
        if (i == 1000) return 3;
        if (i == 10000) return 4;
        if (i == 100000) return 5;
        if (i == 1000000) return 6;
        if (i == 10000000) return 7;
        if (i == 100000000) return 8;
        if (i == 1000000000) return 9;
        return 10;
    }
}