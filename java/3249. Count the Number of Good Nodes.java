class Solution {
    int answer = 0;
    public int countGoodNodes(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] i : edges) {
            graph.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            graph.computeIfAbsent(i[1], k -> new ArrayList<>()).add(i[0]);
        }
        getCount(graph, 0, -1);
        return answer;
    }
    private int getCount(Map<Integer, List<Integer>> graph, int current, int parent) {
        if (!graph.containsKey(current)) {
            answer++;
            return 1;
        }
        int previous = -1;
        int total = 0;
        boolean flag = true;
        for (int next : graph.get(current)) {
            if (next == parent) continue;
            int count = getCount(graph, next, current);
            if (previous == -1) previous = count;
            if (count != previous) flag = false;
            total += count;
        }
        if (flag) answer++;
        return total + 1;
    }
}