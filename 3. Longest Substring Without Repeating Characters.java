class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int[] counts = new int[256];
        int answer = 0;
        for (int right = 0; right < s.length(); right++) {
            counts[s.charAt(right)]++;
            while (left < right && counts[s.charAt(right)] == 2) {
                counts[s.charAt(left)]--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}