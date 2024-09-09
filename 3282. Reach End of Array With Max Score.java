class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long answer = 0;
        int previous = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(previous)) {
                answer += (long)nums.get(previous) * (i - previous);
                previous = i;
            }
        }
        if (previous != nums.size()-1) {
            answer += (long)nums.get(previous) * (nums.size()- 1 - previous);
        }
        return answer;
    }
}

