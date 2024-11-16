class Solution {
    private static final int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] primes = new boolean[(int)Math.pow(10, Math.max(m,n))];
        getPrimes(primes);
        Map<Integer, Integer> primeFreq = new HashMap<>();
        int maxFreq = 0;
        int answer = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : directions) {
                    int x = i;
                    int y = j;
                    int number = 0;
                    while (x >= 0 && y >= 0 && x < m && y < n) {
                        number *= 10;
                        number += mat[x][y];
                        if (number >= 10 && primes[number]) {
                            primeFreq.put(number, primeFreq.getOrDefault(number, 0) + 1);
                            if (primeFreq.get(number) > maxFreq || (primeFreq.get(number) == maxFreq && answer < number)) {
                                maxFreq = primeFreq.get(number);
                                answer = number;
                            }
                        }
                        x += d[0];
                        y += d[1];
                    }
                }
            }
        }
        return answer;
    }
    private void getPrimes(boolean[] primes) {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i]) {
                int index = i+i;
                while (index < primes.length) {
                    primes[index] = false;
                    index += i;
                }
            }
        }
    }
}

