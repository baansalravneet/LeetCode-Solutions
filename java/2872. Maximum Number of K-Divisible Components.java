class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = getGraph(edges, n);
        int[] count = new int[1];
        dfs(0, -1, graph, values, k, count);
        return count[0];
    }
    
    private int dfs(
        int node,
        int parent,
        List<Integer>[] graph,
        int[] values,
        int k,
        int[] count
    ) {
        int sum = 0;
        for (int next : graph[node]) {
            if (next == parent) continue;
            sum += dfs(next, node, graph, values, k, count);
            sum %= k;
        }
        sum += values[node];
        sum %= k;
        if (sum == 0) count[0]++;
        return sum;
    }

    private List<Integer>[] getGraph(int[][] edges, int n) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}