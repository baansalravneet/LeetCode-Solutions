class Solution {
    public int minDays(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return helper(n, cache);
    }
    private int helper(int n, Map<Integer, Integer> cache) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) return cache.get(n);
        int answer = 1 + Math.min(
                n % 2 + helper(n/2, cache),
                n % 3 + helper(n/3, cache)
        );
        cache.put(n, answer);
        return answer;
    }
}

