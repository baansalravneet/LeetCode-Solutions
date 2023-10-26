class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int MOD = 1000000007;
        Map<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp.containsKey(arr[i] / arr[j])) {
                    dp.put(arr[i], dp.get(arr[i]) + dp.get(arr[j])*dp.get(arr[i]/arr[j]));
                    dp.put(arr[i], dp.get(arr[i]) % MOD);
                }
            }
        }
        long result = 0;
        for (long i : dp.values()) {
            result += i;
            result %= MOD;
        }
        return (int)result;
    }
}
