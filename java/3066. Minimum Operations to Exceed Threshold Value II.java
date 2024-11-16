class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i : nums) pq.add(i);
        int count = 0;
        while (pq.peek() < k) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(Math.min(a,b)*2 + Math.max(a,b));
            count++;
        }
        return count;
    }
}