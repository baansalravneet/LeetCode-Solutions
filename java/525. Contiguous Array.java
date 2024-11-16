class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum--;
            else sum++;

            if (sum == 0) {
                answer = Math.max(answer, i+1);
            }

            if (map.containsKey(sum)) {
                answer = Math.max(i - map.get(sum), answer);
            } else {
                map.put(sum, i);
            }
        }
        return answer;
    }
}
