class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (start == end) continue;
            int distance = edge[2];
            graph.putIfAbsent(start, new HashMap<>());
            graph.putIfAbsent(end, new HashMap<>());
            distance = Math.min(distance, Math.min(graph.get(start).getOrDefault(end, Integer.MAX_VALUE), graph.get(end).getOrDefault(start, Integer.MAX_VALUE)));
            graph.get(start).put(end, distance);
            graph.get(end).put(start, distance);
        }
        int[] distances = new int[n];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[0] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int timeSoFar = current[1];
            if (visited[node]) continue;
            visited[node] = true;
            Map<Integer, Integer> neighbourhood = graph.get(node);
            if (neighbourhood == null) continue;
            for (int neighbour: neighbourhood.keySet()) {
                if (disappear[neighbour] <= timeSoFar + neighbourhood.get(neighbour)) continue;
                distances[neighbour] = Math.min(distances[neighbour], timeSoFar + neighbourhood.get(neighbour));
                if (!visited[neighbour]) {
                    pq.add(new int[] {neighbour, distances[neighbour]});
                }
            }
        }
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE) distances[i] = -1;
        }
        return distances;
    }
}
