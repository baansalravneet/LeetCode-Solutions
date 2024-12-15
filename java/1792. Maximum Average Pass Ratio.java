class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Double.compare(getGain(b), getGain(a));
        });
        for (int[] i : classes) pq.add(i);
        while (extraStudents-- > 0) {
            int[] current = pq.poll();
            current[0]++;
            current[1]++;
            pq.add(current);
        }
        double total = 0.0;
        for (int[] c : classes) {
            total += (double)c[0]/c[1];
        }
        return total / classes.length;
    }

    private double getGain(int[] a) {
        double r = (double)a[0] / a[1];
        double nr = ((double)a[0] + 1) / ((double)a[1] + 1);
        return nr - r;
    }
}
