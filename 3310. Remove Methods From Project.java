class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> graph = getGraph(invocations);
        Set<Integer> susGroup = new HashSet<>();
        dfs(graph, k, susGroup);
        List<Integer> answer = new ArrayList<>();
        if (susGroup.size() == n) return answer;
        for (int i = 0; i < n; i++) answer.add(i);
        for (int i : graph.keySet()) {
            if (susGroup.contains(i)) continue;
            for (int next : graph.get(i)) {
                if (susGroup.contains(next)) return answer;
            }
        }
        answer.clear();
        for (int i = 0; i < n; i++) if (!susGroup.contains(i)) answer.add(i);
        return answer;
    }
    private void dfs(Map<Integer, List<Integer>> graph, int current, Set<Integer> susGroup) {
        if (susGroup.contains(current)) return;
        susGroup.add(current);
        if (!graph.containsKey(current)) return;
        for (int next : graph.get(current)) {
            if (susGroup.contains(next)) continue;
            dfs(graph, next, susGroup);
        }
    }
    private Map<Integer, List<Integer>> getGraph(int[][] invocations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : invocations) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }
        return graph;
    }
}