class Solution {
    public int maxDistance(int[] position, int m) {
        int left = 1, right = (int)1e9, answer = -1;
        Arrays.sort(position);
        while (left <= right) {
            int mid = (left+right)/2;
            if (canPlace(position, mid, m-1)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    private boolean canPlace(int[] position, int minDistance, int m) {
        int previousPosition = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - previousPosition >= minDistance) {
                previousPosition = position[i];
                m--;
            }
        }
        return m <= 0;
    }
}
