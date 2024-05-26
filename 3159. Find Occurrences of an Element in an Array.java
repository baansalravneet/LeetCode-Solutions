class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] answer = new int[queries.length];
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) positions.add(i);
        }
        for (int i = 0; i < answer.length; i++) {
            if (queries[i] > positions.size()) answer[i] = -1;
            else answer[i] = positions.get(queries[i]-1);
        }
        return answer;
    }
}