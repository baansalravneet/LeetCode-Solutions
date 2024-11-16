class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> counts = new ArrayList<>();
        for (String row : bank) {
            int count = 0;
            for (int i = 0; i < row.length(); i++) {
                count += row.charAt(i) == '1' ? 1 : 0;
            }
            if (count > 0) {
                counts.add(count);
            }
        }
        int answer = 0;
        for (int i = 1; i < counts.size(); i++) {
            answer += counts.get(i) * counts.get(i-1);
        }
        return answer;
    }
}
