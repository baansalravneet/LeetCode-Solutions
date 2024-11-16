class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            count++;
            floodFill(isConnected, i, visited);
        }
        return count;
    }
    private void floodFill(int[][] graph, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int x = 0; x < graph.length; x++) {
            if (graph[i][x] == 1) floodFill(graph, x, visited);
        }
    }
}