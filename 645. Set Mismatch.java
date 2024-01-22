class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        boolean[] set = new boolean[nums.length+1];
        int total = 0;
        for (int i : nums) {
            if (set[i]) answer[0] = i;
            set[i] = true;
            total += i;
        }
        int n = nums.length;
        int required = (n * (n+1)) / 2;
        answer[1] = required - total + answer[0];
        return answer;
    }
}
