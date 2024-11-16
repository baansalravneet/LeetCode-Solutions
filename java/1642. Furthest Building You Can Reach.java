class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] <= heights[i-1]) continue;
            int diff = heights[i] - heights[i-1];
            if (ladders > 0) {
                pq.add(diff);
                ladders--;
                continue;
            }
            if (!pq.isEmpty()) {
                if (pq.peek() <= diff) {
                    if (bricks < pq.peek()) {
                        return i-1;
                    } else {
                        bricks -= pq.poll();
                        pq.add(diff);
                    }
                } else {
                    if (bricks < diff) {
                        return i-1;
                    } else {
                        bricks -= diff;
                    }
                }
            } else {
                if (bricks < diff) {
                    return i-1;
                } else {
                    bricks -= diff;
                }
            }
        }
        return heights.length-1;
    }

}
