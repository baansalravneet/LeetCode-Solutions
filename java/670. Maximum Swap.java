class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int answer = num;
        for (int i = 0; i < sb.length(); i++) {
            for (int j = i+1; j < sb.length(); j++) {
                swap(sb, i, j);
                answer = Math.max(answer, Integer.parseInt(sb.toString()));
                swap(sb, i, j);
            }
        }
        return answer;
    }
    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
