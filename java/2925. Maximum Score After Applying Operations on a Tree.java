class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer, Set<Integer>> adj = fixGraph(edges);
        Long[][] dp = new Long[edges.length+1][2]; // {answer, sum}
        Long[] answer = helper(adj, values, 0, -1, dp);
        return Math.max(answer[0], answer[1] - values[0]);
    }
    private Long[] helper(Map<Integer, Set<Integer>> adj, int[] values, int current, int parent, Long[][] dp) {
        if (dp[current][0] != null) return dp[current];
        Set<Integer> neighbourhood = adj.get(current);
        if (neighbourhood.size() == 1 && neighbourhood.contains(parent)) return dp[current] = new Long[] {0L, (long) values[current]};
        long notSelected = 0;
        for (int i : neighbourhood) {
            if (i == parent) continue;
            notSelected += helper(adj, values, i, current, dp)[1];
        }
        
        long selected = values[current];
        for (int i : neighbourhood) {
            if (i == parent) continue;
            selected += Math.max(helper(adj, values, i, current, dp)[0], helper(adj, values, i, current, dp)[1] - values[i]);
        }
        return dp[current] = new Long[] {selected, notSelected+values[current]};
    }
    private Map<Integer, Set<Integer>> fixGraph(int[][] edges) {
        Map<Integer, Set<Integer>> answer = new HashMap<>();
        for (int[] edge : edges) {
            answer.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            answer.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        return answer;
    }
}
