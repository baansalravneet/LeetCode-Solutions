class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            adj.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.pollFirst();
                if (current == arr.length-1) return steps;
                visited[current] = true;
                if (current != 0 && !visited[current-1]) {
                    q.addLast(current-1);
                }
                if (current != arr.length-1 && !visited[current+1]) {
                    q.addLast(current+1);
                }
                for (int next : adj.get(arr[current])) {
                    if (!visited[next]) {
                        q.addLast(next);
                    }
                }
                adj.get(arr[current]).clear();
            }
            steps++;
        }
        return -1;
    }
}
