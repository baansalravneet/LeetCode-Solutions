class Solution {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0]-1, k -> new ArrayList<>()).add(edge[1]-1);
            graph.computeIfAbsent(edge[1]-1, k -> new ArrayList<>()).add(edge[0]-1);
        }
        int[] colours = new int[n];
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colours[i] == 0) {
                List<Integer> group = new ArrayList<>();
                if (!isBipartite(graph, colours, i, 1, group)) return -1;
                groups.add(group);
            }
        }
        int answer = 0;
        for (List<Integer> group : groups) {
            int lsp = 0;
            for (int i : group) {
                lsp = Math.max(lsp, bfs(graph, i, new boolean[n]));
            }
            answer += lsp;
        }
        return answer;
    }
    private int bfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        int level = 0;
        Deque<Integer> q = new LinkedList<>();
        q.addLast(node);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollFirst();
                if (visited[current]) continue;
                visited[current] = true;
                if (!graph.containsKey(current)) continue;
                for (int next : graph.get(current)) {
                    if (visited[next]) continue;
                    q.addLast(next);
                }
            }
            level++;
        }
        return level;
    }
    private boolean isBipartite(
        Map<Integer, List<Integer>> graph,
        int[] colours,
        int i,
        int colour,
        List<Integer> group
    ) {
        if (colours[i] != 0) return colours[i] == colour;
        colours[i] = colour;
        group.add(i);
        if (!graph.containsKey(i)) return true;
        for (int neighbour : graph.get(i)) {
            if (!isBipartite(graph, colours, neighbour, 3-colour, group)) {
                return false;
            }
        }
        return true;
    }
}