class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, Integer> outDegrees = new HashMap<>();
        for (int[] p : pairs) {
            int start = p[0], end = p[1];
            graph.computeIfAbsent(start, k -> new LinkedList<>()).add(end);
            inDegrees.put(end, inDegrees.getOrDefault(end, 0) + 1);
            outDegrees.put(start, outDegrees.getOrDefault(start, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int startNode = -1;
        for (int node : outDegrees.keySet()) {
            if (outDegrees.get(node) == inDegrees.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }
        if (startNode == -1) startNode = pairs[0][0];
        dfs(startNode, graph, result);
        Collections.reverse(result);
        int[][] answer = new int[pairs.length][2];
        for (int i = 1; i < result.size(); i++) {
            answer[i-1][0] = result.get(i-1);
            answer[i-1][1] = result.get(i);
        }
        return answer;
    }
    private void dfs(int current, Map<Integer, Deque<Integer>> graph, List<Integer> result) {
        Deque<Integer> next = graph.get(current);
        while(next != null && !next.isEmpty()) {
            int i = next.pollFirst();
            dfs(i, graph, result);
        }
        result.add(current);
    }
}
