class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int p = nums[i] * nums[j];
                freq.put(p, freq.getOrDefault(p, 0) + 1);
            }
        }
        int answer = 0;
        for (int i : freq.values()) {
            answer += 2 * i * (i-1);
        }
        return answer;
    }
}

