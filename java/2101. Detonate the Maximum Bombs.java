class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int[] i : bombs) graph.add(new ArrayList<>());
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i != j && inRange(bombs[i], bombs[j])) {
                    graph.get(i).add(j);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < graph.size(); i++) {
            answer = Math.max(answer, dfs(graph, i, new boolean[graph.size()]));
        }
        return answer;
    }
    private int dfs(List<List<Integer>> graph, int current, boolean[] visited) {
        if (visited[current]) return 0;
        visited[current] = true;
        int answer = 1;
        for (int i : graph.get(current)) {
            if (visited[i]) continue;
            answer += dfs(graph, i, visited);
        }
        return answer;
    }
    private boolean inRange(int[] a, int[] b) {
        long x1 = a[0], x2 = b[0], y1 = a[1], y2 = b[1], r = a[2];
        long distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
        long range = r*r;
        return distance <= range;
    }
}