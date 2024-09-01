class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] coord : queries) {
            pq.add(Math.abs(coord[0]) + Math.abs(coord[1]));
            if (pq.size() < k) {
                answer[index++] = -1;
            } else if (pq.size() == k) {
                answer[index++] = pq.peek();
            } else {
                pq.poll();
                answer[index++] = pq.peek();
            }
        }
        return answer;
    }
}