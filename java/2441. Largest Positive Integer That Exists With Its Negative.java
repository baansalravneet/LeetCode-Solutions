class Solution {
    public int findMaxK(int[] nums) {
        int answer = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (i > 0 && set.contains(-i)) {
                answer = Math.max(answer, i);
            }
        }
        return answer == Integer.MIN_VALUE ? -1 : answer;
    }
}