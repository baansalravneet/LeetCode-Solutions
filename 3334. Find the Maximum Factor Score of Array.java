class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;
        long[] preGCD = new long[n];
        long[] preLCM = new long[n];
        long[] sufGCD = new long[n];
        long[] sufLCM = new long[n];

        preGCD[0] = nums[0];
        preLCM[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preGCD[i] = gcd(nums[i], preGCD[i-1]);
            preLCM[i] = lcm(nums[i], preLCM[i-1]);
        }

        sufGCD[n-1] = nums[n-1];
        sufLCM[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            sufGCD[i] = gcd(sufGCD[i+1], nums[i]);
            sufLCM[i] = lcm(sufLCM[i+1], nums[i]);
        }

        long answer = preGCD[n-1] * preLCM[n-1];
        if (n > 1) {
            for (int i = 1; i < n-1; i++) {
                answer = Math.max(answer, gcd(preGCD[i-1], sufGCD[i+1]) * lcm(preLCM[i-1], sufLCM[i+1]));
            }
            answer = Math.max(answer, preGCD[n-2] * preLCM[n-2]);
            answer = Math.max(answer, sufGCD[1] * sufLCM[1]);
        }

        return answer;

    }

    private long lcm(long a, long b) {
        return (long) a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (a < b) return gcd(b, a);
        return b == 0 ? a : gcd(b, a % b);
    }

}