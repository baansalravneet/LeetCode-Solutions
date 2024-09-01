class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }
    private double helper(double x, long n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        if (n < 0) return helper(1/x, -n);
        if (n % 2 == 0) {
            double answer = helper(x, n/2);
            return answer * answer;
        }
        return x * helper(x, n-1);
    }
}