class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[n];
        for (int i = 0; i < relations.length; i++) {
            int source = relations[i][0]-1;
            int destination = relations[i][1]-1;
            inDegrees[destination]++;
            map.computeIfAbsent(source, k -> new ArrayDeque<>()).addLast(destination);
        }

        int[] startTimes = new int[n];
        // you want to take the courses which end first
        Queue<Integer> q = new PriorityQueue<>((a,b) -> startTimes[a]+time[a]-startTimes[b]-time[b]);
        Arrays.fill(startTimes, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                startTimes[i] = 0;
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            int currentStartTime = startTimes[current];
            if (!map.containsKey(current)) continue;
            Deque<Integer> neighbours = map.get(current);
            while (!neighbours.isEmpty()) {
                int next = neighbours.pollFirst();
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    startTimes[next] = Math.min(currentStartTime + time[current], startTimes[next]);
                    q.add(next);
                }
            }
        }
        for (int i : startTimes) {
            System.out.print(i +" ");
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, startTimes[i] + time[i]);
        }
        return answer;
    }
}
