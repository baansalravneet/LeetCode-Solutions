class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] answer = new int[nums.length-k+1];
        LOOP: for (int i = 0; i < nums.length-k+1; i++) {
            for (int j = i+1; j < i+k; j++) {
                if (nums[j] != nums[j-1]+1) {
                    answer[i] = -1;
                    continue LOOP;
                }
            }
            answer[i] = nums[i+k-1];
        }
        return answer;
    }
}

