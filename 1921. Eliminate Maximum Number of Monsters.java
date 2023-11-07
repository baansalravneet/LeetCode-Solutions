class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> {
            double timeA = (double)dist[a]/speed[a];
            double timeB = (double)dist[b]/speed[b];
            if (timeA <= timeB) return -1;
            return 1;
        });
        for (int i = 0; i < dist.length; i++) {
            pq.add(i);
        }
        int count = 0;
        int timePassed = 0;
        while (!pq.isEmpty()) {
            int nextMonster = pq.poll();
            if (dist[nextMonster] <= timePassed * speed[nextMonster]) {
                return count;
            }
            count++;
            timePassed++;
        }
        return count;
    }
}
