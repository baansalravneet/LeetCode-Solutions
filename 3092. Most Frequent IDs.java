class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] answer = new long[n];
        PriorityQueue<Ele> pq = new PriorityQueue<>((a,b) -> {
            if (b.count > a.count) return 1;
            else return -1;
        });
        Map<Integer, Long> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0L) + freq[i]);
            pq.add(new Ele(nums[i], count.get(nums[i])));
            while (!pq.isEmpty() && (count.get(pq.peek().id) != pq.peek().count || count.get(pq.peek().id) == 0)) pq.poll();
            answer[i] = pq.isEmpty() ? 0 : pq.peek().count;
        }
        return answer;
    }
}

class Ele {
    int id;
    long count;
    Ele(int id, long count) {
        this.id = id;
        this.count = count;
    }
}


