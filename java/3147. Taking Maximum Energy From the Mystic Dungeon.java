class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int answer = Integer.MIN_VALUE;
        for (int i = energy.length-1; i > energy.length-1-k; i--) {
            int currentSum = 0;
            for (int j = i; j >= 0; j -= k) {
                currentSum += energy[j];
                answer = Math.max(answer, currentSum);
            }
        }
        return answer;
    }
}