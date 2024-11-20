class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) return -1;
        int answer = s.length();
        int left = s.length()-1;
        int right = s.length()-1;
        while (left >= 0) {
            count[s.charAt(left)-'a']--;
            while (right >= left && (count[0] < k || count[1] < k || count[2] < k)) {
                count[s.charAt(right)-'a']++;
                right--;
            }
            answer = Math.min(answer, left-1 + s.length()-right);
            left--;
        }
        return answer;
    }
}