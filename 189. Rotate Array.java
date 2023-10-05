class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        int gcd = gcd(k,n);
        if (gcd == 1) {
            int temp = nums[0];
            for (int j = k; j != 0; j = (j+k)%n) {
                int t = nums[j];
                nums[j] = temp;
                temp = t;
            }
            nums[0] = temp;
        } else {
            for (int i = 0; i < gcd; i++) {
                int temp = nums[i];
                for (int j = i+k; j != i; j = (j+k)%n) {
                    int t = nums[j];
                    nums[j] = temp;
                    temp = t;
                }
                nums[i] = temp;
            }
        }
    }
    private int gcd(int a, int b) {
        if (b % a == 0) return a;
        return gcd(b%a, a);
    }
}
