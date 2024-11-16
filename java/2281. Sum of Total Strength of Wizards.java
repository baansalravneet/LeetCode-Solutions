class Solution {
    private static final long MOD = (long)1e9+7;
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] left = getLeft(strength);
        int[] right = getRight(strength);
        long[] prePrefix = getPrePrefix(strength);
        long answer = 0;
        for (int i = 0; i < strength.length; i++) {
            int leftIndex = left[i];
            int rightIndex = right[i];
            long leftElements = (long)i - leftIndex;
            long rightElements = (long)rightIndex - i;
            long leftAggregate = (i-1 < 0 ? 0 : prePrefix[i-1]) - (leftIndex-1 < 0 ? 0 : prePrefix[leftIndex-1]);
            leftAggregate %= MOD;
            long rightAggregate = (rightIndex-1 < 0 ? 0 : prePrefix[rightIndex-1]) - (i-1 < 0 ? 0 : prePrefix[i-1]);
            rightAggregate %= MOD;
            long value = leftElements * rightAggregate;
            value %= MOD;
            value += MOD;
            value -= (rightElements * leftAggregate) % MOD;
            value %= MOD;
            answer += strength[i] * value;
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
    private long[] getPrePrefix(int[] arr) {
        long[] prefix = new long[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
            prefix[i] %= MOD;
        }
        long[] result = new long[arr.length];
        result[0] = prefix[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i-1] + prefix[i];
            result[i] %= MOD;
        }
        return result;
    }
}


