class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int answer = 0, count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) count++;
            answer += freq.getOrDefault(count-k, 0);
            freq.put(count, freq.getOrDefault(count, 0) + 1);
        }
        return answer;
    }
}
