class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] i : meetings) {
            int p1 = i[0];
            int p2 = i[1];
            int time = i[2];
            graph.computeIfAbsent(p1, k -> new ArrayList<>()).add(new int[] {p2, time});
            graph.computeIfAbsent(p2, k -> new ArrayList<>()).add(new int[] {p1, time});
        }
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        Deque<int[]> bfs = new ArrayDeque<>();
        bfs.addFirst(new int[] {0,0});
        bfs.addFirst(new int[] {firstPerson, 0});
        while (!bfs.isEmpty()) {
            int[] current = bfs.pollLast();
            if (!graph.containsKey(current[0])) continue;
            for (int[] next : graph.get(current[0])) {
                if (next[1] >= current[1] && earliest[next[0]] > next[1]) {
                    earliest[next[0]] = next[1];
                    bfs.addFirst(new int[] {next[0], next[1]});
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) answer.add(i);
        }
        return answer;
    }
}

