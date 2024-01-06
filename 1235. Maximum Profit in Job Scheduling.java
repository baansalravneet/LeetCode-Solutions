// Overlapping intervals problem but you want to select a particular interval.
// So you can't greedily pick up the first job that you get or the highest paying job.
// Definitely a DP problem.
// Sorting on start time.
// At every job, you'd have the option to take the job or not.
// If you take the job, you'll have to skip all the jobs that start before the end time of the
// current job.
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a,b) -> a.startTime - b.startTime);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(jobs, 0, dp);
    }
    private int helper(Job[] jobs, int index, int[] dp) {
        if (index >= jobs.length) return 0;
        if (dp[index] != -1) return dp[index];
        Job currentJob = jobs[index];
        // take the job
        int answer1 = currentJob.profit + helper(jobs, findNextIndex(jobs, jobs[index].endTime, index+1, jobs.length-1), dp);
        // do not take the job
        int answer2 = helper(jobs, index+1, dp);
        dp[index] = Math.max(answer1, answer2);
        return dp[index];
    }

    private int findNextIndex(Job[] jobs, int target, int left, int right) {
        int answer = right+1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (jobs[mid].startTime >= target) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}

class Job {
    int startTime;
    int endTime;
    int profit;
    Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
