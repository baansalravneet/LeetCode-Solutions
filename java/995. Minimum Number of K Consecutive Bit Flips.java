class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int answer = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i-k) {
                q.pollFirst();
            }
            int parity = q.size() % 2;
            int value = parity == 0 ? nums[i] : 1-nums[i];
            if (value == 0) {
                if (i > nums.length-k) {
                    return -1;
                }
                q.addLast(i);
                answer++;
            }
        }
        return answer;
    }
}

