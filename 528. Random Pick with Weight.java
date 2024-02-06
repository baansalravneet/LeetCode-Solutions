class Solution {
    private int[] prefix;
    private int total;
    private Random random;

    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i-1] + w[i];
        }
        total = prefix[w.length-1];
        random = new Random();
    }
    
    public int pickIndex() {
        int randomNumber = random.nextInt(total);
        return findIndex(randomNumber);
    }
    private int findIndex(int randomNumber) {
        int left = 0;
        int right = prefix.length-1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (prefix[mid] > randomNumber) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
