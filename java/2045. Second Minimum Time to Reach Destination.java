class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int[] updates = new int[n+1];
        q.add(new int[]{1, 0});
        distances[1] = 0;
        Map<Integer, List<Integer>> graph = getGraph(edges);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (updates[current[0]] > 2) continue;
            if (current[0] == n) {
                if (updates[current[0]] == 2) return distances[n];
            }
            for (int next : graph.get(current[0])) {
                if (updates[next] == 2) continue;
                int nextGreen = getNextGreen(current[1], change);
                if (distances[next] != nextGreen + time) {
                    updates[next]++;
                    distances[next] = nextGreen + time;
                }
                q.add(new int[]{next, nextGreen + time});
            }
        }
        return -1;
    }
    private int getNextGreen(int current, int change) {
        int cycles = current / change;
        if (cycles % 2 == 0) return current;
        return (cycles + 1) * change;
    }
    private Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }
}