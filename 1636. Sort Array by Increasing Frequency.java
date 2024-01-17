class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for (int i : nums) {
            freq[i+100]++;
        }
        return IntStream.of(nums).boxed().sorted((a,b) -> {
            if (freq[a+100] == freq[b+100]) {
                return b - a;
            }
            return freq[a+100] - freq[b+100];
        }).mapToInt(i -> i).toArray();
    }
}

