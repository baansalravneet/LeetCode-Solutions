class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int count = 0;
        Deque<Integer> bfs = new ArrayDeque<>();
        bfs.addLast(0);
        while (!bfs.isEmpty()) {
            int current = bfs.pollFirst();
            if (visited[current]) continue;
            visited[current] = true;
            count++;
            List<Integer> keys = rooms.get(current);
            for (int key : keys) {
                if (!visited[key]) bfs.addLast(key);
            }
        }
        return count == rooms.size();
    }
}