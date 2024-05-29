class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums2) {
            freq.put(i*k, freq.getOrDefault(i*k, 0) + 1);
        }
        long answer = 0;
        for (int i : nums1) {
            for (int factor : getFactors(i)) {
                answer += freq.getOrDefault(factor, 0);
            }
        }
        return answer;
    }
    private List<Integer> getFactors(int num) {
        List<Integer> answer = new ArrayList<>();
        int i = 1;
        for (i = 1; i*i < num; i++) {
            if (num % i == 0) {
                answer.add(i);
                answer.add(num/i);
            }
        }
        if (i*i == num) {
            answer.add(i);
        }
        return answer;
    }
}
