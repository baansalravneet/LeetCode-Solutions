class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            adj.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[] {destination, weight});
            adj.computeIfAbsent(destination, k -> new ArrayList<>()).add(new int[] {source, weight});
        }
        int n = edges.length + 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) continue;
            result[i] = count(adj, i, signalSpeed, n);
        }
        return result;
    }
    private int count(Map<Integer, List<int[]>> adj, int source, int signalSpeed, int n) {
        boolean[] visited = new boolean[n];
        visited[source] = true;
        int answer = 0, counted = 0;
        for (int[] next : adj.get(source)) {
            int count = dfs(adj, visited, next[0], signalSpeed, n, next[1]);
            answer += count * counted;
            counted += count;
        }
        return answer;
    }
    private int dfs(Map<Integer, List<int[]>> adj,
                    boolean[] visited, int currentNode,
                    int signalSpeed, int n, int currentDistance)
    {
        int answer = 0;
        if (currentDistance % signalSpeed == 0) answer++;
        visited[currentNode] = true;
        for (int[] next : adj.get(currentNode)) {
            if (visited[next[0]] == true) continue;
            answer += dfs(adj, visited, next[0], signalSpeed, n, currentDistance + next[1]);
        }
        return answer;
    }
}