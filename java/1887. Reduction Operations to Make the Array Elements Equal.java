class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int index = nums.length - 1;
        int count = 0;
        while (index >= 0) {
            int current = nums[index];
            while (index >= 0 && nums[index] == current) {
                count++;
                index--;
            }
            if (index < 0) continue;
            answer += count;
        }
        return answer;
    }
}
