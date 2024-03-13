class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pairs = new PriorityQueue<>((a,b) -> nums1[a.get(0)] + nums2[a.get(1)] - nums1[b.get(0)] - nums2[b.get(1)]);
        for (int i = 0; i < nums1.length; i++) {
            pairs.add(List.of(i, 0));
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0) {
            List<Integer> current = pairs.poll();
            int index1 = current.get(0);
            int index2 = current.get(1);
            result.add(List.of(nums1[index1], nums2[index2]));
            if (index2 < nums2.length - 1) pairs.add(List.of(index1, index2+1));
        }
        return result;
    }
}

