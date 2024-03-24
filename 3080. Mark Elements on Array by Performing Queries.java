class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        PriorityQueue<Num> heap = new PriorityQueue<>((a,b) -> {
            if (a.val == b.val) return a.index - b.index;
            return a.val - b.val;
        });
        Set<Integer> markedIndices = new HashSet<>();
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            heap.add(new Num(nums[i], i));
        }
        long[] answer = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int index = q[0];
            int count = q[1];
            if (!markedIndices.contains(index)) {
                total -= nums[index];
                markedIndices.add(index);
            }
            while (count > 0 && !heap.isEmpty()) {
                Num current = heap.poll();
                if (markedIndices.contains(current.index)) continue;
                markedIndices.add(current.index);
                total -= current.val;
                count--;
            }
            answer[i] = total;
        }
        return answer;
    }
}

class Num {
    int val;
    int index;
    Num(int val, int index) {
        this.val = val;
        this.index = index;
    }
}