class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = find(spells[i], potions, success);
        }
        return answer;
    }
    private int find(int spell, int[] potions, long success) {
        int answer = -1;
        int left = 0;
        int right = potions.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)potions[mid] * spell < success) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        if (answer == -1) return 0;
        return potions.length - answer;
    }
}