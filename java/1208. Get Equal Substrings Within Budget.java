class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int current = 0;
        int answer = 0;
        for (int right = 0; right < s.length(); right++) {
            current += Math.abs(s.charAt(right) - t.charAt(right));
            while (left <= right && current > maxCost) {
                current -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
