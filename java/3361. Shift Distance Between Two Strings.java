class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = s.length();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int source = s.charAt(i) - 'a';
            int target = t.charAt(i) - 'a';
            long cost = get(source, target, nextCost, previousCost);
            answer += cost;
        }
        return answer;
    }
    private long get(int s, int t, int[] next, int[] prev) {
        return Math.min(
            getCost(s, t, next, true),
            getCost(s, t, prev, false)
        );
    }
    private long getCost(int s, int t, int[] cost, boolean forward) {
        long answer = 0;
        while (s != t) {
            answer += cost[s];
            if (forward) s++;
            else s--;
            s = (s+26) % 26;
        }
        return answer;
    }
}