class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            if (a[1]-a[0] == b[1]-b[0]) {
                return a[1] - b[1];
            }
            return a[1] - a[0] - b[1] + b[0];
        });
        List<int[]> qIndex = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            qIndex.add(new int[]{queries[i], i});
        }
        Collections.sort(qIndex, (a,b) -> a[0] - b[0]);
        List<int[]> answer = new ArrayList<>();
        int intervalIndex = 0;
        for (int i = 0; i < qIndex.size(); i++) {
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= qIndex.get(i)[0]) {
                heap.add(intervals[intervalIndex]);
                intervalIndex++;
            }
            while (!heap.isEmpty() && heap.peek()[1] < qIndex.get(i)[0]) {
                heap.poll();
            }
            if (heap.isEmpty()) answer.add(new int[]{-1, qIndex.get(i)[1]});
            else answer.add(new int[]{heap.peek()[1]-heap.peek()[0]+1, qIndex.get(i)[1]});
        }
        int[] result = new int[queries.length];
        for (int[] a : answer) {
            result[a[1]] = a[0];
        }
        return result;
    }
}

