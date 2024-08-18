class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') count++;
                if (count <= k || j-i+1-count <= k) answer++;
            }
        }
        return answer;
    }
}
