class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum == k) result++;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
