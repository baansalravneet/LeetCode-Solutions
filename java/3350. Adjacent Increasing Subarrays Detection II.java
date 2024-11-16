class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int answer = 1;
        int current = 1;
        int previous = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                current++;
            } else {
                previous = current;
                current = 1;
            }
            answer = Math.max(answer, Math.max(current/2, Math.min(current, previous)));
        }
        return answer;
    }
}
