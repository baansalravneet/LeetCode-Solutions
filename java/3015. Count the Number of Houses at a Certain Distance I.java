class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            bfs(n, i+1, x, y, new HashSet<>(), answer);
        }
        return answer;
    }
    private void bfs(int n, int start, int x, int y, Set<Integer> visited, int[] answer) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollFirst();
                if (current < 1 || current > n) continue;
                if (visited.contains(current)) continue;
                visited.add(current);
                if (count > 0) answer[count-1]++;
                if (current == x) q.addLast(y);
                if (current == y) q.addLast(x);
                q.addLast(current+1);
                q.addLast(current-1);
            }
            count++;
        }
    }
}
