class Solution {
    private static final long MOD = (long)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        long answer = 0;
        int[] left = getLeft(arr);
        int[] right = getRight(arr);
        for (int i = 0; i < arr.length; i++) {
            answer += (long)arr[i] * (right[i] - i) * (i - left[i]);
            answer %= MOD;
        }
        return (int)answer;
    }
    private int[] getLeft(int[] arr) {
        int[] result = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        return result;
    }
    private int[] getRight(int[] arr) {
        int[] result = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? arr.length : stack.peekLast();
            stack.addLast(i);
        }
        return result;
    }
}
