class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = gcd(numsDivide);
        Arrays.sort(nums);
        int answer = 0;
        while (answer < nums.length && gcd % nums[answer] != 0) answer++;
        return answer == nums.length ? -1 : answer;
    }
    private int gcd(int[] nums) {
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer = gcd(answer, nums[i]);
        }
        return answer;
    }
    private int gcd(int a, int b) {
        if (a > b) return gcd(b, a);
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}

