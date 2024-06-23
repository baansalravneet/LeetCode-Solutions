class Solution {
    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        original = nums.clone();
        rand = new Random();
    }
    
    public int[] reset() {
        return original.clone();
    }
    
    public int[] shuffle() {
        int[] shuffled = original.clone();
        for (int i = 0; i < shuffled.length; i++) {
            int index = rand.nextInt(shuffled.length-i) + i;
            int temp = shuffled[index];
            shuffled[index] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

