class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = getGraph(edges);
        int answer = -1;
        int minCities = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cities = getCities(i, n, graph, distanceThreshold);
            if (cities < minCities) {
                answer = i;
                minCities = cities;
            } else if (cities == minCities) {
                if (answer < i) answer = i;
            }
        }
        return answer;
    }
    private int getCities(int start, int n, Map<Integer, List<int[]>> graph, int thres) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        pq.add(new int[] {start, 0});
        int count = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (visited[current[0]]) continue;
            visited[current[0]] = true;
            count++;
            if (!graph.containsKey(current[0])) continue;
            for (int[] next : graph.get(current[0])) {
                if (visited[next[0]]) continue;
                if (current[1] + next[1] > thres) continue;
                pq.add(new int[] {next[0], next[1] + current[1]});
            }
        }
        return count;
    }
    private Map<Integer, List<int[]>> getGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[] {to, weight});
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[] {from, weight});
        }
        return graph;
    }
}