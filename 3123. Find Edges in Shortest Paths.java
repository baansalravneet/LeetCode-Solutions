class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int[] edge: edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Node(edge[0], edge[2]));
        }
        int[] distanceSource = findDistances(graph, 0, n);
        int[] distanceTarget = findDistances(graph, n-1, n);
        long minDistance = distanceSource[n-1];
        boolean[] answer = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];
            if ((long)distanceSource[start] + distanceTarget[end] + weight == minDistance) answer[i] = true;
            if ((long)distanceSource[end] + distanceTarget[start] + weight == minDistance) answer[i] = true;
        }
        return answer;
    }
    private int[] findDistances(Map<Integer, List<Node>> graph, int start, int n) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.val]) continue;
            visited[current.val] = true;
            if (!graph.containsKey(current.val)) continue;
            for (Node next : graph.get(current.val)) {
                if (distance[next.val] > current.distance + next.distance) {
                    distance[next.val] = current.distance + next.distance;
                    pq.add(new Node(next.val, distance[next.val]));
                }
            }
        }
        return distance;
    }
}

class Node {
    int val;
    int distance;
    Node(int val, int distance) {
        this.val = val;
        this.distance = distance;
    }
}