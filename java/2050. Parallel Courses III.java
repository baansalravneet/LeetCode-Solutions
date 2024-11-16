class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[n];
        for (int[] edge : relations) {
            int source = edge[0] - 1;
            int destination = edge[1] - 1;
            inDegrees[destination]++;
            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        }

        Deque<Integer> q = new ArrayDeque<>();
        int[] maxTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                maxTime[i] = time[i];
                q.addLast(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.pollFirst();
            if (!graph.containsKey(current)) continue;
            for (int next : graph.get(current)) {
                maxTime[next] = Math.max(maxTime[next], time[next] + maxTime[current]);
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    q.addLast(next);
                }
            }
        }

        int answer = 0;
        for (int i : maxTime) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
}
