class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) freq.put(p, freq.getOrDefault(p, 0)+1);
        Long[] dp = new Long[power.length];
        return find(power, 0, dp, freq);
    }
    private long find(int[] power, int index, Long[] dp, Map<Integer, Integer> freq) {
        if (index >= power.length) return 0;
        if (dp[index] != null) return dp[index];
        // don't take this element
        long answer1 = find(power, nextIndex(power, power[index]+1), dp, freq);
        // take this element
        long answer2 = (long)freq.get(power[index]) * power[index];
        answer2 += find(power, nextIndex(power, power[index]+3), dp, freq);
        return dp[index] = Math.max(answer1, answer2);
    }
    private int nextIndex(int[] power, int target) {
        int left = 0, right = power.length-1;
        int answer = power.length;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (power[mid] >= target) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}
