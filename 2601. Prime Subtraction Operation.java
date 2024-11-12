class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] primes = getPrimes();
        primes[0] = true;
        int currentValue = 1;
        int index = 0;
        while (index < nums.length) {
            int difference = nums[index] - currentValue;
            if (difference < 0) return false;
            if (primes[difference]) index++;
            currentValue++;
        }
        return true;
    }
    private boolean[] getPrimes() {
        boolean[] primes = new boolean[1001];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (primes[i]) {
                for (int j = i+i; j < 1001; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}