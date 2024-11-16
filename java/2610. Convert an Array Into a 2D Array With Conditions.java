class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] count = new int[nums.length+1];
        for (int i : nums) {
            count[i]++;
        }
        for (int i : nums) {
            int freq = count[i];
            while (freq > result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(freq-1).add(i);
            count[i]--;
        }
        return result;
    }
}

