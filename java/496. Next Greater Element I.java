class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums2.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peekLast()) {
                stack.pollLast();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(nums2[i]);
        }
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            index.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = index.get(nums1[i]);
            result[i] = nextGreater[j];
        }
        return result;
    }
}
