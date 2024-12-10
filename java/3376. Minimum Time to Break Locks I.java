class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int len = (int)Math.pow(2, strength.size());
        return find(strength, k, 0, new Integer[len]);
    }
    private int find(
        List<Integer> strength,
        int k,
        int visited,
        Integer[] cache
    ) {
        int setBits = Integer.bitCount(visited);
        int x = 1 + setBits*k;
        if (setBits == strength.size()) return 0;
        if (cache[visited] != null) return cache[visited];
        int answer = (int)1e9;
        for (int i = 0; i < strength.size(); i++) {
            if ((visited & (1<<i)) == 0) {
                visited = visited ^ (1<<i);
                int val = (int)Math.ceil((double)strength.get(i) / x);
                answer = Math.min(answer, val + find(strength, k, visited, cache));
                visited = visited ^ (1<<i);
            }
        }
        return cache[visited] = answer;
    }
}
