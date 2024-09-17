class Solution {
    public long maxScore(int[] a, int[] b) {
        Long[][] cache = new Long[a.length][b.length];
        return find(a, b, 0, 0, cache);
    }
    private long find(int[] a, int[] b, int aIndex, int bIndex, Long[][] cache) {
        if (aIndex >= a.length) return 0;
        if (bIndex >= b.length) return Long.MIN_VALUE + 1_000_000_000_0L;
        if (cache[aIndex][bIndex] != null) return cache[aIndex][bIndex];
        long answer1 = (long)a[aIndex] * b[bIndex] + find(a, b, aIndex+1, bIndex+1, cache);
        long answer2 = find(a, b, aIndex, bIndex+1, cache);
        return cache[aIndex][bIndex] = Math.max(answer1, answer2);
    }
}