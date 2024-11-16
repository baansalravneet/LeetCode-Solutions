class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = getGraph(flights);
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {src, 0});
        while (k-- >= -1 && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.pollFirst();
                costs[current[0]] = Math.min(costs[current[0]], current[1]);
                if (!adj.containsKey(current[0])) continue;
                for (int[] next : adj.get(current[0])) {
                    if (next[1] + current[1] < costs[next[0]]) {
                        int[] addThis = new int[] {next[0], next[1] + current[1]};
                        queue.addLast(addThis);
                    }
                }
            }
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
    private Map<Integer, List<int[]>> getGraph(int[][] flights) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], k -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }
        return adj;
    }
}
