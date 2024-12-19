class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (min == 0 && max-min == i) count++;
        }
        return count;
    }
}
