class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a,b) -> a.difficulty - b.difficulty);
        int[] maxProfit = new int[n];
        maxProfit[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            maxProfit[i] = Math.max(maxProfit[i-1], jobs[i].profit);
        }
        int answer = 0;
        for (int ability : worker) {
            int index = findIndex(jobs, ability);
            if (index == -1) continue;
            answer += maxProfit[index];
        }
        return answer;
    }
    private int findIndex(Job[] jobs, int ability) {
        int left = 0, right = jobs.length-1, answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (jobs[mid].difficulty <= ability) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

class Job {
    int difficulty;
    int profit;
    Job(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}
