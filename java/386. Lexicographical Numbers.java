class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) answer.add(i);
        Collections.sort(answer, (a,b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return answer;
    }
}

