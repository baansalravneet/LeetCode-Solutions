class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>()).add(i+1);
        }
        int[] answer = new int[queries.length];
        for (int x = 0; x < queries.length; x++) {
            int from = queries[x][0];
            int to = queries[x][1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            answer[x] = find(graph, n);
        }
        return answer;
    }
    private int find(Map<Integer, List<Integer>> graph, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.addFirst(0);
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollLast();
                visited[current] = true;
                if (current == n-1) return answer;
                for (int i : graph.get(current)) {
                    if (visited[i]) continue;
                    q.addFirst(i);
                } 
            }
            answer++;
        }
        return answer;
    }
}