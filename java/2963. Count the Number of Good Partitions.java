class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> indexes = new HashMap<>();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!indexes.containsKey(n)) {
                indexes.put(n, intervals.size());
                intervals.add(new int[]{i, i});
            } else {
                int index = indexes.get(n);
                intervals.get(index)[1] = i;
            }
        }
        int previousEnd = -1;
        int groups = 0;
        for (int[] i : intervals) {
            if (i[0] > previousEnd) {
                groups++;
            }
            previousEnd = Math.max(previousEnd, i[1]);
        }
        return calculateResult(groups);
    }
    // 2^(n-1)
    private int calculateResult(int n) {
        long answer = 1;
        for (int i = 0; i < n-1; i++) {
            answer *= 2;
            answer %= MOD;
        }
        return (int)answer;
    }
}