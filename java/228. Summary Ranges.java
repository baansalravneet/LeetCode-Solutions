class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> answer = new ArrayList<>();
        while (i < nums.length) {
            int current = nums[i];
            i++;
            while (i < nums.length && nums[i] == nums[i-1] + 1) {
                i++;
            }
            int start = current;
            int end = nums[i-1];
            if (start == end) answer.add(String.valueOf(start));
            else answer.add(start+"->"+end);
        }
        return answer;
    }
}
