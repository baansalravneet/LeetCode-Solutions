class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] cache = new Integer[arr.length];
        return helper(arr, k, 0, cache);
    }
    private int helper(int[] arr, int k, int index, Integer[] cache) {
        if (index >= arr.length) {
            return 0;
        }
        if (cache[index] != null) return cache[index];
        int answer = 0;
        int groupMax = 0;
        for (int i = index; i < index+k && i < arr.length; i++) {
            groupMax = Math.max(groupMax, arr[i]);
            int groupSize = i-index+1;
            answer = Math.max(
                    answer,
                    groupSize * groupMax + helper(arr, k, i+1, cache)
            );
        }
        return cache[index] = answer;
    }
}
