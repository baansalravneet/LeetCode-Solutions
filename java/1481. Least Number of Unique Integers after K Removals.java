class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : freq.values()) {
            pq.add(i);
        }
        while (!pq.isEmpty() && pq.peek() <= k) {
            k -= pq.poll();
        }
        return pq.size();
    }
}
