class Solution {
    /*
     * Partition jobDifficulty such that the sum of the max
     * of each paritition is minimum
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        Integer[][] cache = new Integer[jobDifficulty.length+1][d+1];
        return helper(cache, jobDifficulty, 0, d);
    }
    private int helper
    (
        Integer[][] cache,
        int[] arr,
        int index,
        int daysLeft
    ) {

        if (daysLeft <= 0 && index < arr.length) {
            return 1000000;
        }
        if (arr.length == index) {
            if (daysLeft == 0) {
                return 0;
            } else {
                return 1000000;
            }
        }

        if (cache[index][daysLeft] != null) {
            return cache[index][daysLeft];
        }

        int result = 1000000;
        int maxSoFar = -1;
        // do all the tasks from index to i today
        for (int i = index; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            result = Math.min(result, maxSoFar + helper(cache, arr, i+1, daysLeft-1));
        }
        return cache[index][daysLeft] = result;
    }
}