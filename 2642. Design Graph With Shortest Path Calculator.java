class Graph {
    private List<List<Pair<Integer, Integer>>> adj;

    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        int[] distances = new int[adj.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node1] = 0;
        pq.add(new Pair<>(node1, 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int currentNode = current.getKey();
            int currentDistance = current.getValue();
            if (currentNode == node2) return distances[node2];
            List<Pair<Integer, Integer>> neighbourhood = adj.get(currentNode);
            if (neighbourhood == null) continue;
            for (Pair<Integer, Integer> x : neighbourhood) {
                int nextNode = x.getKey();
                int nextDistance = x.getValue();
                if (distances[nextNode] > currentDistance + x.getValue()) {
                    distances[nextNode] = currentDistance + x.getValue();
                    pq.add(new Pair<>(nextNode, distances[nextNode]));
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
