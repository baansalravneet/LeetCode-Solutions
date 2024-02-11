class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) sb.append('1');
            else if (nums[i] == nums[i-1]) sb.append('0');
            else sb.append('2');
        }
        StringBuilder p = new StringBuilder();
        for (int i : pattern) {
            if (i == 1) p.append('1');
            else if (i == 0) p.append('0');
            else p.append('2');
        }
        String s = sb.toString();
        String px = p.toString();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(px, i) == i) count++;
        }
        return count;
    }
}

