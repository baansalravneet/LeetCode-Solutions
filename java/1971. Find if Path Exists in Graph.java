class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, int curr, int destination, boolean[] visited) {
        if (curr == destination) return true;
        visited[curr] = true;
        for (int next : graph.get(curr)) {
            if (visited[next]) continue;
            boolean answer = dfs(graph, next, destination, visited);
            if (answer) return true;
        }
        return false;
    }
}