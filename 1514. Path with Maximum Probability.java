class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Node>> graph = getGraph(n, edges, succProb);
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));
        pq.add(new Node(start_node, 1));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.val == end_node) return current.prob;
            if (visited[current.val]) continue;
            visited[current.val] = true;
            if (!graph.containsKey(current.val)) continue;
            for (Node next : graph.get(current.val)) {
                if (visited[next.val]) continue;
                pq.add(new Node(next.val, current.prob*next.prob));
            }
        }
        return 0;
    }
    private Map<Integer, List<Node>> getGraph(int n, int[][] edges, double[] succProb) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, prob));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, prob));
        }
        return graph;
    }
}

class Node {
    int val;
    double prob;
    Node(int val, double prob) {
        this.val = val;
        this.prob = prob;
    }
}

