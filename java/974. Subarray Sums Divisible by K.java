class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum < 0) sum += k;
            if (sum == 0) answer++;
            if (prefixMap.containsKey(sum)) {
                answer += prefixMap.get(sum);
            }
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}
