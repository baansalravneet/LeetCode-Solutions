class Solution {
    private final static int INF = (int)2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] graph = getGraph(n, edges);
        int distance = run(n, graph, source, destination);
        if (distance < target) return new int[0][0];
        boolean matched = distance == target;
        for (int[] edge : edges) {
            if (edge[2] != -1) continue;
            int from = edge[0], to = edge[1];
            edge[2] = matched ? INF : 1;
            graph[from].add(new int[]{to, edge[2]});
            graph[to].add(new int[]{from, edge[2]});
            if (!matched) {
                int newDistance = run(n, graph, source, destination);
                if (newDistance <= target) {
                    matched = true;
                    edge[2] += target - newDistance;
                }
            }
        }
        return matched ? edges : new int[0][0];
    }

    private int run(int n, List<int[]>[] graph, int source, int destination) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        pq.add(new int[] {source, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int current = node[0], distance = node[1];
            if (current == destination) return distance;
            if (visited[current]) continue;
            visited[current] = true;
            for (int[] next : graph[current]) {
                int child = next[0], weight = next[1];
                if (visited[child]) continue;
                pq.add(new int[] {child, distance + weight});
            }
        }
        return INF;
    }

    private List<int[]>[] getGraph(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            if (weight == -1) continue;
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }
        return graph;
    }
}
