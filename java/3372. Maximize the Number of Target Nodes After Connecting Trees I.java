class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int t2Add = getMax(edges2, k-1);
        int[] result = new int[edges1.length+1];
        Map<Integer, List<Integer>> graph = getGraph(edges1);
        for (int i = 0; i <= edges1.length; i++) {
            result[i] = t2Add + bfs(graph, i, edges1.length+1, k);
        }
        return result;
    }
    private int bfs(Map<Integer, List<Integer>> graph, int start, int n, int k) {
        Deque<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.addLast(start);
        int steps = 0;
        int count = 0;
        while (!q.isEmpty() && steps <= k) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollFirst();
                if (visited[current]) continue;
                visited[current] = true;
                count++;
                for (int next : graph.get(current)) {
                    if (visited[next]) continue;
                    q.addLast(next);
                }
            }
            steps++;
        }
        return count;
    }
    private int getMax(int[][] edges, int k) {
        Map<Integer, List<Integer>> graph = getGraph(edges);
        int answer = -1;
        for (int i = 0; i <= edges.length; i++) {
            answer = Math.max(answer, bfs(graph, i, edges.length+1, k));
        }
        return answer;
    }
    private Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        return graph;
    }
}