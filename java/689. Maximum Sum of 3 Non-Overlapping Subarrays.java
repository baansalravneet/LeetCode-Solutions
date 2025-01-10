class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        Integer[][] cache = new Integer[n+1][3];
        dp(prefix, k, 1, 0, cache);
        int[] result = new int[3];
        dfs(prefix, k, 1, 0, cache, result);
        return result;
    }

    private void dfs(
        int[] prefix,
        int k,
        int index,
        int selected,
        Integer[][] cache,
        int[] result
    ) {
        if (selected == 3) return;
        if (index > prefix.length-k) return;
        int select = prefix[index+k-1]-prefix[index-1]+dp(prefix, k, index+k, selected+1, cache);
        int reject = dp(prefix, k, index+1, selected, cache);
        if (select >= reject) {
            result[selected] = index-1;
            dfs(prefix, k, index+k, selected+1, cache, result);
        } else {
            dfs(prefix, k, index+1, selected, cache, result);
        }
    }

    private int dp(
        int[] prefix,
        int k,
        int index,
        int selected,
        Integer[][] cache
    ) {
        if (selected == 3) return 0;
        if (index > prefix.length-k) return Integer.MIN_VALUE;
        if (cache[index][selected] != null) return cache[index][selected];
        return cache[index][selected] = Math.max(
            prefix[index+k-1]-prefix[index-1] + dp(prefix, k, index+k, selected+1, cache),
            dp(prefix, k, index+1, selected, cache)
        );
    }
}

