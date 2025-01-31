class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Map<Integer, List<Integer>> reversedGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            reversedGraph.computeIfAbsent(favorite[i], k -> new ArrayList<>()).add(i);
        }
        int longestCycle = 0, twoCycle = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            Map<Integer, Integer> distances = new HashMap<>();
            int current = i;
            int distance = 0;
            while (true) {
                if (visited[current]) break;
                visited[current] = true;
                distances.put(current, distance++);
                int neighbour = favorite[current];
                if (distances.containsKey(neighbour)) {
                    int cycleLength = distance - distances.get(neighbour);
                    longestCycle = Math.max(longestCycle, cycleLength);
                    if (cycleLength == 2) {
                        boolean[] cycleNodes = new boolean[n];
                        cycleNodes[current] = true;
                        cycleNodes[neighbour] = true;
                        twoCycle += 2 + bfs(current, cycleNodes, reversedGraph) + bfs(neighbour, cycleNodes, reversedGraph);
                    }
                    break;
                }
                current = neighbour;
            }
        }
        return Math.max(longestCycle, twoCycle);
    }
    private int bfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[] {node, 0});
        int maxDistance = 0;
        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            if (!graph.containsKey(current[0])) continue;
            for (int next : graph.get(current[0])) {
                if (visited[next]) continue;
                visited[next] = true;
                maxDistance = Math.max(maxDistance, current[1] + 1);
                q.addLast(new int[] {next, current[1] + 1});
            }
        }
        return maxDistance;
    }
}
