class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = getOrder(getGraph(rowConditions, k), k);
        int[] colOrder = getOrder(getGraph(colConditions, k), k);
        if (rowOrder.length == 0 || colOrder.length == 0) {
            return new int[0][0];
        }
        int[][] answer = new int[k][k];
        for (int i = 1; i <= k; i++) {
            answer[rowOrder[i]][colOrder[i]] = i;
        }
        return answer;
    }
    private Map<Integer, List<Integer>> getGraph(int[][] edges, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
        }
        return graph;
    }

    private int[] getOrder(Map<Integer, List<Integer>> graph, int k) {
        int[] inDegrees = new int[k+1];
        for (int i = 1; i <= k; i++) {
            if (!graph.containsKey(i)) continue;
            for (int x : graph.get(i)) inDegrees[x]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (inDegrees[i] == 0) q.addLast(i);
        }
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.pollFirst();
            order.add(current);
            if (!graph.containsKey(current)) continue;
            for (int next : graph.get(current)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) q.addLast(next);
            }
        }
        if (order.size() != k) return new int[0];
        int[] result = new int[k+1];
        int index = 0;
        for (int i : order) {
            result[i] = index++;
        }
        return result;
    }
}