class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], 1+lds[j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n-1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                answer = Math.max(answer, lis[i] + lds[i] - 1);
            }
        }
        return n - answer;
    }
}
