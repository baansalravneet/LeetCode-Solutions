class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val < 0) val = -nums[i];
            val -= 1;
            if (nums[val] < 0) answer.add(val+1);
            else nums[val] = -nums[val];
        }
        return answer;
    }
}
