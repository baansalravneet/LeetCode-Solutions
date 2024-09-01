class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] i : prerequisites) {
            int from = i[1];
            int to = i[0];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        int[] inDegrees = new int[numCourses];
        for (int[] i : prerequisites) {
            inDegrees[i[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) q.addLast(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int current = q.pollFirst();
            count++;
            if (!graph.containsKey(current)) continue;
            for (int i : graph.get(current)) {
                inDegrees[i]--;
                if (inDegrees[i] == 0) q.addLast(i);
            }
        }
        return count == numCourses;
    }
}