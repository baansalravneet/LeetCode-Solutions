class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        long score = 0;
        boolean[] mark = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
        }
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            if (mark[current[1]]) continue;
            mark[current[1]] = true;
            score += current[0];
            if (current[1] > 0) mark[current[1]-1] = true;
            if (current[1] < nums.length-1) mark[current[1]+1] = true;
        }
        return score;
    }
}

