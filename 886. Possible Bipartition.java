class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) return true;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int[] colour = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (!adj.containsKey(i)) continue;
            if (colour[i] == 0) {
                if (bfs(adj, colour, i) == false) return false;
            }
        }
        return true;
    }
    private boolean bfs(Map<Integer, List<Integer>> adj, int[] colour, int i) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(i);
        colour[i] = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollFirst();
                for (int next : adj.get(current)) {
                    if (colour[next] == 0) {
                        colour[next] = -colour[current];
                        q.addLast(next);
                    } else if (colour[next] == colour[current]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
