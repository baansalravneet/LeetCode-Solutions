class Solution {
    public String largestNumber(int[] nums) {
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2, (a, b) -> {
            String s1 = String.format("%d%d", a, b);
            String s2 = String.format("%d%d", b, a);
            return compare(s1, s2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i : nums2) {
            if (i == 0 && sb.isEmpty()) continue;
            sb.append(String.valueOf(i));
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
    private int compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) continue;
            if (c1 > c2) return -1;
            else return 1;
        }
        return 0;
    }
}
