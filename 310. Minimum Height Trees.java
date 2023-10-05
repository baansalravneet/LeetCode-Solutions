/*
    "There are a few new things you can learn from this question.
    This is a topological sort problem because you will be runing a BFS with nodes with inDegrees 1.
    The idea is to remove all the outer nodes and move inside and find the ""center of gravity"".
    Keep reducing the inDegrees and push the nodes to the queue which inDegree = 1.
    Another thing to understand is that there can be maximum of 2 nodes which make the min height tree."
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0 || n == 1){
            return List.of(0);
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegrees = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            adj.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adj.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
            inDegrees[source]++;
            inDegrees[destination]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                q.addLast(i);
            }
        }
        // we are going to keep removing the nodes with 1 indegree until we have only 2 nodes left
        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int current = q.pollFirst();
                inDegrees[current]--;
                List<Integer> neighbours = adj.get(current);
                for (int next : neighbours) {
                    if (inDegrees[next] == 0) continue;
                    else {
                        inDegrees[next]--;
                        if (inDegrees[next] == 1) {
                            q.addLast(next);
                        }
                    }
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            answer.add(q.pollFirst());
        }
        return answer;
    }
}
