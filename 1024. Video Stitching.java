class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b) -> a[0] - b[0]);
        int stitchingPosition = 0;
        int currentMax = 0;
        int count = 0;
        // we only want to break out of this loop when we reach `time`
        for (int i = 0; stitchingPosition < time; ) {
            // we check what clips can be attached next
            while (i < clips.length && clips[i][0] <= stitchingPosition) {
                currentMax = Math.max(currentMax, clips[i][1]);
                i++;
            }
            // if the current max doesn't change, we return
            if (stitchingPosition == currentMax) {
                return -1;
            }
            stitchingPosition = currentMax;
            count++;
        }
        return count;
    }
}
