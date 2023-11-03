class Solution {
    private static final String push = "Push";
    private static final String pop = "Pop";
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int current = 1;
        for (int i = 0; i < target.length; i++) {
            int next = target[i];
            while (current != next) {
                answer.add(push);
                answer.add(pop);
                current++;
            }
            answer.add(push);
            current++;
        }
        return answer;
    }
}
