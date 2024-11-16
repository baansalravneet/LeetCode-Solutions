class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[] {0};
        List<Integer>[] graph = new List[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (graph[a] == null) graph[a] = new ArrayList<>();
            if (graph[b] == null) graph[b] = new ArrayList<>();
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] count = new int[n];
        countVerticesSubtree(graph, count, 0, -1);
        int[] result = new int[n];
        rootDistance(graph, result, 0, -1, 0);
        totalDistance(graph, result, count, 0, -1);
        return result;
    }
    private int countVerticesSubtree(List<Integer>[] graph, int[] count, int curr, int previous) {
        int c = 1;
        for (int next : graph[curr]) {
            if (next == previous) continue;
            c += countVerticesSubtree(graph, count, next, curr);
        }
        count[curr] = c;
        return c;
    }
    private void rootDistance(List<Integer>[] graph, int[] result, int curr, int previous, int distance) {
        result[0] += distance;
        for (int next : graph[curr]) {
            if (next == previous) continue;
            rootDistance(graph, result, next, curr, distance+1);
        }
    }
    private void totalDistance(List<Integer>[] graph, int[] result, int[] count, int curr, int previous) {
        if (previous != -1) {
            result[curr] = result[previous] + result.length - 2 * count[curr];
        }
        for (int next : graph[curr]) {
            if (next == previous) continue;
            totalDistance(graph, result, count, next, curr);
        }
    }
}