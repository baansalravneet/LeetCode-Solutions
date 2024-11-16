class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> answer = new ArrayList<>();
        if (n < 3) return answer;
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                for (int j = i+i; j <= n; j = j+i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 0; i <= n/2; i++) {
            int a = i;
            int b = n-i;
            if (primes[a] && primes[b]) {
                answer.add(List.of(a,b));
            }
        }
        return answer;
    }
}
