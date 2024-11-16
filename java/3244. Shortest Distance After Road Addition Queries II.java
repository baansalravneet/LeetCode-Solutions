class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            graph.put(i, i+1);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            if (!graph.containsKey(from) || graph.get(from) >= to) {
                answer[i] = graph.size();
                continue;
            }
            int j = graph.get(from);
            while (j < to) {
                j = graph.remove(j);
            }
            graph.put(from, to);
            answer[i] = graph.size();
        }
        return answer;
    }
}