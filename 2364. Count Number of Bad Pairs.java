class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] - i;
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        long count = 0;
        for (int i : map.values()) {
            count += ((long)i * (i-1))/2;
        }
        long n = nums.length;
        return (n*(n-1))/2 - count;
    }
}
