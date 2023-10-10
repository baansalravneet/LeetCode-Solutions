class Solution {
    public int minOperations(int[] input) {
        int n = input.length;
        Set<Integer> set = new HashSet<>();
        for (int i : input) set.add(i);
        
        int[] nums = new int[set.size()];
        int index = 0;
        for (int i : set) {
            nums[index++] = i;
        }
        Arrays.sort(nums);
        int j = 0;
        int answer = n;
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            int lastElementTheoretically = nums[i] + n;
            while (j < nums.length && nums[j] < lastElementTheoretically) j++;
            answer = Math.min(answer, n - (j - i));
        }
        return answer;
    }
}
