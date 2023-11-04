class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        return Math.max(left.length == 0 ? 0 : Arrays.stream(left).max().getAsInt(), right.length == 0 ? 0 : n - Arrays.stream(right).min().getAsInt());
    }
}
