class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Worker(wage[i], quality[i]));
        }
        Collections.sort(workers, (a,b) -> {
            double aRatio = a.getRatio();
            double bRatio = b.getRatio();
            if (aRatio < bRatio) return -1;
            return 1;
        });
        double answer = Double.MAX_VALUE;
        int currentTotalQuality = 0;
        PriorityQueue<Integer> qualities = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            qualities.add(workers.get(i).quality);
            currentTotalQuality += workers.get(i).quality;
            if (qualities.size() > k) {
                currentTotalQuality -= qualities.poll();
            }
            if (qualities.size() == k) {
                answer = Math.min(answer, currentTotalQuality * workers.get(i).getRatio());
            }
        }
        return answer;
    }
}

class Worker {
    int wage;
    int quality;
    Worker(int wage, int quality) {
        this.wage = wage;
        this.quality = quality;
    }
    double getRatio() {
        return (double)wage/quality;
    }
}
